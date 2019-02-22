package PinDuoduo;


import java.util.Scanner;

//三个数的乘积，这些数包含全部是正数，全部是负数，正数和负数(3个最大值和1大2小-->最大值）
public class ThreeMax {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();  //数组大小
        long[] a=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();  //给数组输入
        }
        long max=Max(a,n);
        System.out.println(max);
    }

    public static long Max(long[] a,int len)
    {
        Long max1=Long.MIN_VALUE;  //用long的最小值，最大值一定大于等于MIN_VALUE
        Long max2=Long.MIN_VALUE;
        Long max3=Long.MIN_VALUE;
        Long min1=Long.MAX_VALUE; //用long的最大值，最小值一定小于等于MAX_VALUE
        Long min2=Long.MAX_VALUE;

        //获取最大的3个值和最小的两个值
        for(int i=0;i<len;i++)
        {
            //该数大于最大值，3个max都要依次改变
            if(a[i]>max1)
            {
                max3=max2;
                max2=max1;
                max1=a[i];
            }
            else if(a[i]>max2)
            {
                max3=max2;
                max2=a[i];
            }
            else if(a[i]>max3)
            {
                max3=a[i];
            }
            //那么max值都不变

            //该比最小值小，min值都改变
            if(a[i]<min1)
            {
                min2=min1;
                min1=a[i];
            }
            else if(a[i]<min2)
            {
                min2=a[i];
            }
            //那么min值不变


        }
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
        System.out.println(min1);
        System.out.println(min2);
        System.out.println(max3*max2*max1);
        System.out.println(max1*min2*min1);
        return Math.max(max3*max2*max1,max1*min2*min1);
    }
}
