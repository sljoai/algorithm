package sort;

public class InnerSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []nums={49,38,65,97,26,13,27,49,55,4,5};
		for(int i:nums){
			System.out.print(i+"\t");
		}
		System.out.println("");
		//insertSort(nums,0,nums.length-1);
		shellSort(nums);
		for(int i:nums){
			System.out.print(i+"\t");
		}
	}
	
	/**
	 * 插入排序：将当前数插入前面已经排好序的子数组中，依次进行
	 * @param nums
	 */
	public static void  insertSort(int []nums,int start,int end) {
		if(nums==null) return;
		int length=nums.length;
		int tmp;//存储中间变量
		int k=0;//记录元素插入的位置
		for(int i=start;i<=end;i++){
			tmp=nums[i];
			k=i;
			for(int j=i-1;j>=start;j--){
				if(nums[j]>tmp){//当有序子数组的元素比当前数大的时候
					nums[j+1]=nums[j];
					k=j;
				}else{
					break;
				}
			}
			nums[k]=tmp;
		}
		return;
	}
	
	/**
	 * Shell排序：先对子数组进行排序，再对父数组排序。子数组是从父数组中以某个间隔长度挑选出来的。间隔以指数的形式一次递减，且间隔代表了子数组的个数、
	 * 参考博客：http://blog.csdn.net/morewindows/article/details/6668714
	 * @param nums
	 */
	public static void shellSort(int []nums) {
		int len=nums.length;
		for(int gap=len/2;gap>0;gap/=2){//gap即为组数，亦为步长，按指数递减，
			for(int i=0;i<gap;i++){//对每一组进行插入排序
				
				for(int j=i;j<len;j+=gap){//真正插入排序
					int tmp=nums[j];//暂存
					int index=j;//表示待插入的位置
					for(int k=j-gap;k>=0;k-=gap){
						if(nums[k]>tmp){
							nums[k+gap]=nums[k];//往后移动一位
							index=k;
						}else{
							break;
						}
					}
					nums[index]=tmp;
				}
			}
		}
		return;
	}

}
