package com.hf.sparsearray;

import java.util.Iterator;

import sun.tools.jar.resources.jar;

public class SparseArray {
	public static void main(String[] args) {
		
		//创建二位数组
		int[][] sparseArr = new int[11][11];
		//1表示黑子 2表示红子
		sparseArr[0][1] = 1;
		sparseArr[1][2] = 2;
		//原始的二位数组
		for (int[] is : sparseArr) {
			for (int i : is) {
				System.out.printf("%d\t",i);
			}
			System.out.println();
		}
		
		//获得有效数字
		int sum = 0;
		for (int[] is : sparseArr) {
			for (int i : is) {
				if (i != 0) {
					sum++;
				}
			}
		}
		System.out.println("总数："+sum);
		
		//将数组转换为稀疏数组
		int[][] sparseArray = new int[sum+1][3];
		//给稀疏数组赋值
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		int count = 0;//标记第几个非零数据
		//遍历二位数组
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (sparseArr[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = sparseArr[i][j];
				}
			}
		}
		
		System.out.println();
		//输出稀疏数组的形式
		System.out.println("稀疏数组的形式：：");
		for (int i = 0; i < sparseArray.length; i++) {
			for (int j = 0; j < sparseArray.length; j++) {
				System.out.printf("%d\t",sparseArray[i][j]);
			}
			System.out.println();
		}
		
		//将稀疏数组恢复成二位数组
		int[][] chessArr = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		//将数值塞进去
		for (int i = 1; i < sparseArray.length; i++) {
			chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		//输出二位数组
		System.out.println("恢复后的数组：：");
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < chessArr.length; j++) {
				System.out.printf("%d\t",chessArr[i][j]);
			}
			System.out.println();
		}
		
	}
}
