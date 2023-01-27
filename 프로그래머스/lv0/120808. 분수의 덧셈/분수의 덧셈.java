class Solution {
    public int LCM(int a,int b){
        int tmpLCM=1;
        int min=(a>b)?b:a;
        for(int i=2;i<=min;i++){
            if(a%i==0 && b%i==0){
                a/=i;
                b/=i;
                tmpLCM*=i;
            }
        }
        if (tmpLCM==1){
            return a*b;
        }
        else{
            return tmpLCM*a*b;
        }
    }
    public int GCD(int a,int b){
        int tmpGCD=1;
        int min=(a>b)?b:a;
        for(int i=2;i<=min;i++){
            if(a%i==0 && b%i==0){
                a/=i;
                b/=i;
                tmpGCD*=i;
            }
        }
        return tmpGCD;
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int[] answer = {0,0};
        int denom=LCM(denom1,denom2); //분모
        int tmp1=denom/denom1;
        int tmp2=denom/denom2;
        int numer=(tmp1*numer1)+(tmp2*numer2);
        int gcd=GCD(numer,denom);
        answer[0]=numer/gcd;
        answer[1]=denom/gcd;
        return answer;
    }
}