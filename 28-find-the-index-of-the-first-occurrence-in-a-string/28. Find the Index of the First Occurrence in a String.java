class Solution {
  	   public int strStr(String haystack, String needle) {
		//Runtime: 5 ms, faster than 97.14% of Java online submissions for Implement strStr().
		//Memory Usage: 43.3 MB, less than 27.29% of Java online submissions	
		int nlen=needle.length()-1;
        int hylen=haystack.length();
        
        if(needle.equals("")){
            return 0;
        }
        
        if(needle.length()>haystack.length()){
            return -1;
        }

        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                //If needle's first char matches
                // then also check if needle's last character is matching too.
                // if it not matching no need to check needle's every characters.

                if(!
                   (
                       (i+nlen)<hylen && needle.charAt(needle.length()-1) ==haystack.charAt(i+nlen)
                       )
                  ){
                   continue; 
                }
                
                int returnind=i;
                int foundCounter=0;

                for(int j=0;j<needle.length() && (i+j)<haystack.length();j++){

                    if(needle.charAt(j)!=haystack.charAt(i+j)){
                        break;                        
                    }else{
                        foundCounter++;                        
                    }

                }
        
                if(foundCounter==needle.length())
                    return returnind;

            }
            
        }
        return -1;
    }
}

