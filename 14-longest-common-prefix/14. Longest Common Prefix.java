class Solution {
	public String longestCommonPrefix(String[] strs) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<strs.length;i++) {
			if(strs[i].length()<min)
				min=strs[i].length();
		}
		String anString="";
		boolean flag=true;
		for (int i = 0; i < min; i++) {
			char ch=strs[0].charAt(i);

			for (int j = 0; j < strs.length; j++) {
				if(strs[j].charAt(i)!=ch) {
					flag=false;
					break;
				}
			}
			if (flag) {
				anString+=ch;
			}else {
				break;
			}
		}
		return anString;
	}
}