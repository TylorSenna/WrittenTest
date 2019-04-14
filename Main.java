package com.company;

import com.company.test1.LinkList;
import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main { //头条正式批 配置饮料

    public static int[][] arrays;
    public static int[][] arrays2;
    public static int num2_convert = 0;

    public static int fun(){
        int result = 0;
        int num2 = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(arrays[i][j] == 2){
                    num2++;
                }
            }
        }
        if(num2 == 0){  //先判断有没有程序员，这种表示没有，返回-1
            return -1;
        }
        while(true){
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    if(arrays[i][j] == 2){
                        num2++;
                        convert(i, j);
                    }
                }
            }
            if(num2_convert == 0){
                break;
            }
            result++;
            num2_convert = 0;
            for(int k=0; k<10; k++){
                for(int j=0; j<10; j++){
                    arrays[k][j] = arrays2[k][j];
                }
            }
        }
        int num = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(arrays[i][j] != 1){
                    num++;
                }
            }
        }
        if(num == 100){
            return result;
        }else {
            return -1;
        }
    }

    public static void convert(int X, int Y){  //找出2周围的1 变成2
        if(X == 0){
            if(Y == 0){
                if(arrays2[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
            }else if(Y == 9){
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
            }
            else {
                if(arrays2[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
            }
        }else if(X == 9){
            if(Y == 0){
                if(arrays2[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
            }else if(Y == 9){
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
            }
            else {
                if(arrays[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
            }
        }else {
            if(Y == 0){
                if(arrays2[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
            }else if(Y == 9){
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
            }
            else {
                if(arrays2[X][Y+1] == 1){
                    arrays2[X][Y+1] = 2;
                    num2_convert++;
                }
                if(arrays2[X][Y-1] == 1){
                    arrays2[X][Y-1] = 2;
                    num2_convert++;
                }
                if(arrays2[X-1][Y] == 1){
                    arrays2[X-1][Y] = 2;
                    num2_convert++;
                }
                if(arrays2[X+1][Y] == 1){
                    arrays2[X+1][Y] = 2;
                    num2_convert++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] chars;
        arrays = new int[10][10];
        arrays2 = new int[10][10];
        String s = "";
        int result = -1;
        int i=0;
        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            if(s.equals("")){
                break;
            }
            chars = s.split(" ");
            for(int j=0; j<chars.length; j++){
                arrays[i][j] = Integer.parseInt(chars[j]);
            }
            i++;
        }
        for(int k=0; k<10; k++){
            for(int j=0; j<10; j++){
                arrays2[k][j] = arrays[k][j];
            }
        }
        result = fun();
        System.out.println(result);
    }


    /*
    public static float fun(int V, int[] percent, int[] juice){   //京东  黑暗料理 通过91%？？？
        float sum = 0;
        int n = percent.length;
        float[] temp = new float[n];
        float little;
        for(int i=0; i<n; i++){
            temp[i] = (float)juice[i] / percent[i];
        }
        little = temp[0];
        for(int i=0; i<n; i++){
            if(little >= temp[i]){
                little = temp[i];
            }
        }
        for(int i=0; i<n; i++){
            sum += (float)percent[i]* little;
        }
        if(sum >= V){
            return V;
        }else {
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int[] percent = new int[n];
        int[] juice = new int[n];
        float result;
        for (int i=0; i<n;i++){
            percent[i]=scanner.nextInt();
        }
        for (int i=0; i<n;i++){
            juice[i]=scanner.nextInt();
        }
        result = fun(V,percent,juice);
        System.out.printf("%.4f",result);
    }
     */



    /*   喝橙汁
    public static BigInteger fun(BigInteger s, BigInteger[] array){
        BigInteger sum = BigInteger.ZERO;
        BigInteger result = BigInteger.ZERO;
        int n = array.length;
        for(int i =0; i<n; i++){
            sum = sum.add(array[i]);
        }
        if(s.compareTo(sum)==1){
            return BigInteger.valueOf(-1);
        }

        BigInteger[] temp = new BigInteger[n];
        BigInteger min = array[0];
        for(int i=0; i<n; i++){
            if(min.compareTo(array[i])==1){
               min = array[i];
            }
        }
        sum = BigInteger.ZERO;
        for(int i=0; i<n; i++){
            if(min.compareTo(array[i])== -1){
                temp[i] = array[i];
                temp[i] = temp[i].subtract(min);
                sum = sum.add(temp[i]);
            }
        }

        if(sum.compareTo(s) == 1){
            return min;
        }else {
            BigInteger ss = BigInteger.ZERO;
            s = s.subtract(sum); //现在开始每一瓶的ml值都相等
            while(s.compareTo(BigInteger.ZERO) == 1){
                if((ss = s.subtract(BigInteger.valueOf(n))).compareTo(BigInteger.ZERO) != -1){
                    s = s.subtract(BigInteger.valueOf(n));
                    min = min.subtract(BigInteger.ONE);
                }else {
                    return min;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger s = scanner.nextBigInteger();
        BigInteger[] juice = new BigInteger[n];
        BigInteger result;
        for (int i=0; i<n;i++){
            juice[i]=scanner.nextBigInteger();
        }
        result = fun(s,juice);
        System.out.println(result);
    }*/




    /*
    // 输入一段英文 含有标点符号    逆序输出 单词不逆序
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String origin = new String("");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((origin = br.readLine())!= null){
            System.out.println("内容:"+origin);
            String[] array = origin.split("\\b|\\.|,|'|\\?|!");
            for(int i= array.length-1; i>=0; i--){
                System.out.printf("%s",array[i]);
            }
        }
        //有个bug就是标点后的空格应该在标点前面，除了末尾（没有空格，所以标点前面不需要空格）

    }*/


    /*  兵种分类
    public static double fun(int[] Ai_array, int[] Bi_array){
        int num = Ai_array.length/3;
        int[] wuli = new int[num];
        int[] fashi = new int[num];
        int[] all = new int[num];
        int[] ABi_array = new int[Ai_array.length];
        int W1=0,W2=0,W3=0;
        for(int i=0; i<num; i++){
            wuli[i] = Ai_array[i];
            fashi[i] = Bi_array[i+num];
            all[i] = Ai_array[i+2*num];
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] Ai_array = new int[n];
        int[] Bi_array = new int[n];
        double result = 0.00;
        for (int i=0; i<n;i++){
            Ai_array[i]=scanner.nextInt();
        }
        for (int i=0; i<n;i++){
            Bi_array[i]=scanner.nextInt();
        }
        result = fun(Ai_array,Bi_array);
        System.out.printf("%2.2f",result);
    }*/

    /*     次品率
    public static double fun(int[] s_array){
        int sum = 0;
        for(int i =0; i<s_array.length; i++){
            if(s_array[i]<5900){
                sum++;
            }
        }
        return sum/(double)s_array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s_array = new int[n];
        double result = 0.00;
        for (int i=0; i<n;i++){
            s_array[i]=scanner.nextInt();
        }
        result = fun(s_array)*100;
        System.out.printf("%2.2f%%",result);
    }*/



    /*
    public static void caculate(int nn, int[] score, int[] num){   //算法还是错误的。。。我是按照输入数组是从小到大来搞的。。。。
        for(int i=0; i<nn; i++){
            if(i == 0){
                if(score[0]<=score[1] && score[0]<=score[nn-1]){
                    num[0] = 1;
                }else if(score[0]>score[1] && score[0]<=score[nn-1]){
                    num[0] = num[1]+1;
                }else if(score[0]<=score[1] && score[0]>score[nn-1]){
                    num[0] = num[nn-1]+1;
                }else if(score[0]>score[1] && score[0]>score[nn-1]){
                    if(score[1]>score[nn-1]){
                        num[0] = num[1]+1;
                    }else {
                        num[0] = num[nn-1]+1;
                    }
                }
            }else if(i == nn-1){
                if(score[nn-1]<=score[0] && score[0]<=score[nn-2]){
                    num[nn-1] = 1;
                }else if(score[nn-1]>score[0] && score[0]<=score[nn-2]){
                    num[nn-1] = num[0]+1;
                }else if(score[nn-1]<=score[0] && score[0]>score[nn-2]){
                    num[nn-1] = num[nn-2]+1;
                }else if(score[nn-1]>score[0] && score[0]>score[nn-2]){
                    if(score[0]>score[nn-2]){
                        num[nn-1] = num[0]+1;
                    }else {
                        num[nn-1] = num[nn-2]+1;
                    }
                }
            }else {
                if(score[i]<=score[i-1] && score[0]<=score[i+1]){
                    num[i] = 1;
                }else if(score[i]>score[i-1] && score[0]<=score[i+1]){
                    num[i] = num[i-1]+1;
                }else if(score[i]<=score[i-1] && score[0]>score[i+1]){
                    num[i] = num[i+1]+1;
                }else if(score[i]>score[i-1] && score[0]>score[i+1]){
                    if(score[i-1]>score[i+1]){
                        num[i] = num[i-1]+1;
                    }else {
                        num[i] = num[i+1]+1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array_n = new int[n][];
        int[] nn = new int[n];
        int[][] result = new int[n][];;
        int result_sum = 0;

        for (int i=0; i<n;i++){
            nn[i] = scanner.nextInt();
            array_n[i] = new int[nn[i]];
            result[i] = new int[nn[i]];
            for(int j=0; j<nn[i]; j++){
                array_n[i][j] = scanner.nextInt();
                result[i][j] = 0;
            }
        }
        for (int i=0; i<n;i++){
            Main.caculate(nn[i], array_n[i], result[i]);
            for(int j=0; j<nn[i]; j++){
                result_sum += result[i][j];
            }
            System.out.println(result_sum);
            result_sum = 0;
        }
    }
    */
    /*   王大锤自动校对程序
    public static String convert(String s){
        char[] chars = s.toCharArray();
        String temp;
        String result;
        for(int i=0; i<s.length()-2; i++){
            temp = new String(chars);
            if(i+2<temp.length() && chars[i] == chars[i+1] && chars[i+1] == chars[i+2]){
                result = temp.substring(0,i+2);
                if(i+3<=s.length()){
                    result = result.concat(temp.substring(i+3,temp.length()));
                }
                chars = result.toCharArray();
            }
        }
        for(int i=0; i<chars.length-3; i++){
            temp = new String(chars);
            if(i+3<temp.length() && (chars[i] == chars[i+1])&&(chars[i+2] == chars[i+3])&&(chars[i+1] != chars[i+2])){
                result = temp.substring(0,i+3);
                if(i+4<=s.length()){
                    result = result.concat(temp.substring(i+4,temp.length()));
                }
                chars = result.toCharArray();
            }
        }
        System.out.println("哈哈哈");
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s_array = new String[n];
        String[] result = new String[n];
        for (int i=0; i<n;i++){
            s_array[i]=scanner.next();
            result[i]= Main.convert(s_array[i]);
            System.out.println(result[i]);
        }
    }*/

}

/*  腾讯 圆桌算法测试
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();
        LinkList linkList = new LinkList(n);
        LinkList.Node temp = linkList.start;
        LinkList.Node pre = temp;
        if(n == 2){
            if(s == 1){//只可能是 2 1 1  输出 1 2
                System.out.println(linkList.start.index);
                System.out.println(linkList.end.index);
            }else {//只可能是 2 2 1  输出 2 1
                System.out.println(linkList.end.index);
                System.out.println(linkList.start.index);
            }
        }else {
            while(true){
                for(int i = 1; i<s;i++){//跳过前s-1个
                    //System.out.println(temp.index);
                    if (linkList.num<m-s){
                        break;
                    }
                    pre = temp;
                    if (temp.next != null){
                        temp = temp.next;
                    }else {
                        break;
                    }
                }
                for (int j =m-s; j>0; j--){
                    //System.out.println(temp.index);
                    pre = temp;
                    if (temp.next != null){
                        temp = temp.next;
                    }else {
                        break;
                    }
                }
                if (linkList.num<m-s){
                    break;
                }
                System.out.println(temp.index);
                pre.next = temp.next;
                if (temp.next != null){
                    temp = temp.next;
                }else {
                    break;
                }
                linkList.num--;
            }
        }
        */



    /*   //牛客网第一题 解锁
    public static int open(int n,char[] x_array, char[] y_array){
        int result = 0;
        for(int i=0; i<n; i++){
            int res = x_array[i]-y_array[i];
            if(res <0){//绝对值
                res = 0-res;
            }
            if(res>=0 && res <=5){
                result += res;
            }else if(res>5){
                result = result+10-res;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String x = scanner.next();
        String y = scanner.next();
        if(n!= x.length()){
            System.out.println("n 和 字符串长度不匹配");
            return;
        }
        char [] x_array = x.toCharArray();
        char [] y_array = y.toCharArray();
        int result = Main.open(n,x_array,y_array);
        System.out.println(result);

    }
     */

    /* 牛客网第二题  找斜线 没做出来。。。
    public static int line(int x,int y,int k){
        if(k<0){
            return -1;
        }
        if(x>0&&y>0){//第一象限
            if(x==y){
                if(k<x){//k比坐标还小
                    return -1;
                }else{
                    if (x==1){

                    }else if (x==2){

                    }else if (x==((x/2)+1)){//x大于2时可以判断此种条件下坐标x是奇数
                        if(k==((k/2)+1)){//k是奇数情况
                            return k;
                        }else {//k是偶数情况
                            return x-2;
                        }
                    }else {//坐标x是偶数
                        if(k==((k/2)+1)){//k是奇数情况
                            return x-2;
                        }else {//k是偶数情况
                            return k;
                        }
                    }
                }
            }
        }else if (x<0&&y>0){//第二象限    四个象限逻辑都一样，没时间写了

        }else if (x<0&&y<0){//第三象限

        }else if (x>0&&y<0){//第四象限

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s_array = new String[n];
        int [] result = new int[n];
        for (int i=0; i<n;i++){
            s_array[i]=scanner.next();
            result[i]= Main.line(s_array[i].charAt(0),s_array[i].charAt(1),s_array[i].charAt(2));
            System.out.println(result[i]);
        }
    }*/


    /*    头条  找零
    public static int money(int n){
        int sum = 1024-n;
        int a,b,c,d;
        a = sum/64;
        b = (sum - 64*a)/16;
        c = (sum - 64*a -16*b)/4;
        d = (sum - 64*a -16*b -4*c);
        return a+b+c+d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = Main.money(n);
        System.out.println(result);
    }
     */

    /*   王大锤自动校对程序
    public static String convert(String s){

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s_array = new String[n];
        String[] result = new String[n];
        for (int i=0; i<n;i++){
            s_array[i]=scanner.next();
            result[i]= Main.convert(s_array[i]);
            System.out.println(result[i]);
        }
    }
     */