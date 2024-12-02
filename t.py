from itertools import permutations

def solution(crypt):
    # Helper function to check if the current mapping is valid
    def is_valid_mapping(mapping):
        def word_to_number(word):
            return int(''.join(mapping[char] for char in word))

        num1, num2, num3 = map(word_to_number, crypt)
        return num1 + num2 == num3

    def backtrack(index):
        nonlocal valid_solutions
        if index == len(unique_letters):
            if is_valid_mapping(mapping):
                valid_solutions += 1
            return

        for num in '0123456789':
            if num not in used_numbers:
                mapping[unique_letters[index]] = num
                used_numbers.add(num)
                
                # Skip leading zero constraint
                if any(len(word) > 1 and word[0] in mapping and mapping[word[0]] == '0' for word in crypt):
                    mapping.pop(unique_letters[index])
                    used_numbers.remove(num)
                    continue

                backtrack(index + 1)

                mapping.pop(unique_letters[index])
                used_numbers.remove(num)

    unique_letters = list(set(''.join(crypt)))  # Convert set to list

    if len(unique_letters) > 10:
        return 0

    mapping = {}
    used_numbers = set()
    valid_solutions = 0

    backtrack(0)

    return valid_solutions

# Example Usage
print(solution(["SEND", "MORE", "MONEY"]))  # Output: 1
print(solution(["GREEN", "BLUE", "BLACK"]))  # Output: 12
print(solution(["ONE", "TWO", "THREE"]))  # Output: 0
