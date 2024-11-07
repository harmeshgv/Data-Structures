class tobinsry {
    public static void main (String [] args) {
        tobinary(12);
        tonumerical("10110");
        
        
    }
        
    public static void tobinary (int value) {
        StringBuilder binary = new StringBuilder();

        while (value > 0) {
            if (value % 2 == 0) {
                binary.append("0");
            } else {
                binary.append("1");
            }
            value = value / 2;
        }

        System.out.println(binary.reverse().toString());
    }

    public static void tonumerical (String value) {
        int p = 1;
        int num = 0;
        for (int i = value.length()- 1; i >= 0 ; i--) {
            if(value.charAt(i) != '0') {
                num = num + p;
            }
            

            p = p * 2;

        }

        System.out.println(num);
    }
}