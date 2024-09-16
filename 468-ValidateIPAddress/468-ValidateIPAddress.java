class Solution {
    public String validIPAddress(String queryIP) {
        
        if(queryIP.indexOf('.')>=0) {
            return checkIpv4(queryIP);
        }

        if(queryIP.indexOf(':')>=0) {
            return checkIpv6(queryIP);
        }

        return "Neither";
    }

    private String checkIpv4(String queryIP) {

        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length()-1) == '.') {
            return "Neither";
        }
        String[] comp = queryIP.split("\\.");

        if (comp.length != 4) {
            return "Neither";
        }

        for (String str: comp) {
            if (str.length() == 0 || str.length() > 3 || (str.charAt(0)=='0' && str.length() > 1)) {
                return "Neither";
            }

            for (char ch:str.toCharArray()) {
                if (ch < '0' || ch > '9') {
                    return "Neither";
                }
            }

            int num = Integer.parseInt(str);

            if (num < 0 || num > 255){
                return "Neither";
            }

        }

        return "IPv4";
    }

    private String checkIpv6(String queryIP) {
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length()-1) == ':') {
            return "Neither";
        }

        String[] comp = queryIP.split("\\:");

        if (comp.length != 8) {
            return "Neither";
        }

        for (String str: comp) {
            if (str.length() == 0 || str.length() > 4) {
                return "Neither";
            }

            for (char ch:str.toCharArray()) {
                if ((ch < '0' || ch > '9') && (ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd'&& ch != 'e'&& ch != 'f')
                && (ch != 'A' && ch != 'B' && ch != 'C' &&ch != 'D'&& ch != 'E'&& ch != 'F')) {
                    return "Neither";
                }
            }
        }

        return "IPv6";
    }
}