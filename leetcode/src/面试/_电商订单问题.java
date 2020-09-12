package 面试;
/**
 * 有电商订单为i，j，k。i，j为商品序号，k为数量，n为商品种类，求商品订单量。
 * @param order_list
 * @param order_list[][],n
 * @return arr[];
 * @input order_list=[[0,2,5],[3,4,6],[2,4,7]];n=6
 * @output arr=[5,5,12,13,13,0];
 */
public class _电商订单问题 {
	public static int[] calOrderList(int order_list[][],int n) {
		
		if(order_list.length==0||n==0)
			return null;
		int temp[][] = new int [n+1][2]; //定义n+1行*2列数组 ps：商品共n类，0号计算在内
		for(int i=0;i<order_list.length;i++) { //外循环，定位第i个一维数组，即order_list[i]
			int j;
			for(j=order_list[i][0];j<=order_list[i][1];j++) { 
			//内循环从一维数组的第1列遍历到第2列，
			//如：【0，2，5】遍历结果为，0号商品5件，1号商品5件，2号商品5件
				temp[j][0]=j; //建立的n+1行*2列数组，第1列用商品序号填充，即为j
					temp[j][1] += order_list[i][2]; //对应商品序号的k，即数量
			}
		}
		int arr[] = new int[n+1];
		for(int i =0;i<n+1;i++) {
			arr[i]=temp[i][1];
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[][] order_list= {{0,2,5},{3,4,6},{2,4,7}};
		int n = 6;
		int arr[]=new int[n];
		int start = (int) System.nanoTime();
		arr=calOrderList(order_list, n);
		System.out.println("final:");
		for(int i=0;i<n+1;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int end = (int)System.nanoTime();
		System.out.println("time:"+(end-start)+"ns");
	}

}
