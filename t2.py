def solution(balances, requests):
    cashback_events = {}  # Store pending cashback as {timestamp: {holder_id: cashback_amount}}
    
    for i, request in enumerate(requests):
        parts = request.split()
        action, timestamp, holder_id, amount = parts[0], int(parts[1]), int(parts[2]), int(parts[3])
        
        # Account index is zero-based
        account_index = holder_id - 1
        
        # Process pending cashbacks
        to_remove = []
        for cashback_time in cashback_events:
            if cashback_time <= timestamp:
                for account, cashback in cashback_events[cashback_time].items():
                    balances[account] += cashback
                to_remove.append(cashback_time)
        for cashback_time in to_remove:
            del cashback_events[cashback_time]
        
        if action == "deposit":
            # Deposit the amount into the account
            if account_index < 0 or account_index >= len(balances):
                return [-i - 1]  # Invalid account
            balances[account_index] += amount
        
        elif action == "withdraw":
            # Withdraw the amount from the account
            if account_index < 0 or account_index >= len(balances):
                return [-i - 1]  # Invalid account
            if balances[account_index] < amount:
                return [-i - 1]  # Insufficient balance
            balances[account_index] -= amount
            
            # Schedule cashback after 24 hours
            cashback_time = timestamp + 86400
            cashback_amount = (amount * 2) // 100  # 2% cashback, rounded down
            if cashback_time not in cashback_events:
                cashback_events[cashback_time] = {}
            if account_index not in cashback_events[cashback_time]:
                cashback_events[cashback_time][account_index] = 0
            cashback_events[cashback_time][account_index] += cashback_amount
    
    return balances

print(solution())