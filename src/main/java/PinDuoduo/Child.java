package PinDuoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，
 * 使得最多的小孩上台表演。
 * 可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * 第一行：n，表示h数组元素个数
 *  第二行：n个h数组元素
 *  第三行：m，表示w数组元素个数
 *  第四行：m个w数组元素
 */
//巧克力需要分给最需要的小朋友也就是离该巧克力重量的h[i]
public class Child {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();  //n个小朋友
        float[] h=new float[n];  //n个巧克力
        for(int i=0;i<n;i++)
        {
            h[i]=scanner.nextFloat();  //需要的巧克力重量
        }
        int m=scanner.nextInt();  //现有的巧克力数量
        float[] w=new float[m];  //现有的巧克力重量
        for(int i=0;i<m;i++)
        {
            w[i]=scanner.nextFloat();
        }
        int num=MaxChild(n,h,m,w);
        System.out.println(num);
    }

    public static int MaxChild(int n,float[] h,int m,float[] w) {
        Arrays.sort(h);
        int num=0;
        for(int i=0;i<m;i++)
        {
            int j=0;
            for(j=0;j<n;j++)
            {
                if(h[j]>w[i])  //找到第一个离老师发的巧克力最近的小朋友需要的巧克力
                    break;
            }
            if(j!=0 && h[j-1]!=0)  //只要前一个存在，肯定是小于等于w[i]的巧克力，资源利用最大化
            {
                num++;
                h[j-1]=0;
                Arrays.sort(h);  //再次排序，
            }
        }
        return 0;
    }
}
