class Solution:
    def isHappy(self, n: int) -> bool:
        ls=[]
        while(n!=1):
            if n in ls:
                return False
            ls.append(n)
            sum=0
            while(n>0):
                r=n%10
                sum=sum+r*r
                n=n//10
            n=sum
        return True
        
        