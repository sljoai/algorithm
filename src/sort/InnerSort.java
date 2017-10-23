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
	 * �������򣺽���ǰ������ǰ���Ѿ��ź�����������У����ν���
	 * @param nums
	 */
	public static void  insertSort(int []nums,int start,int end) {
		if(nums==null) return;
		int length=nums.length;
		int tmp;//�洢�м����
		int k=0;//��¼Ԫ�ز����λ��
		for(int i=start;i<=end;i++){
			tmp=nums[i];
			k=i;
			for(int j=i-1;j>=start;j--){
				if(nums[j]>tmp){//�������������Ԫ�رȵ�ǰ�����ʱ��
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
	 * Shell�����ȶ���������������ٶԸ����������������ǴӸ���������ĳ�����������ѡ�����ġ������ָ������ʽһ�εݼ����Ҽ��������������ĸ�����
	 * �ο����ͣ�http://blog.csdn.net/morewindows/article/details/6668714
	 * @param nums
	 */
	public static void shellSort(int []nums) {
		int len=nums.length;
		for(int gap=len/2;gap>0;gap/=2){//gap��Ϊ��������Ϊ��������ָ���ݼ���
			for(int i=0;i<gap;i++){//��ÿһ����в�������
				
				for(int j=i;j<len;j+=gap){//������������
					int tmp=nums[j];//�ݴ�
					int index=j;//��ʾ�������λ��
					for(int k=j-gap;k>=0;k-=gap){
						if(nums[k]>tmp){
							nums[k+gap]=nums[k];//�����ƶ�һλ
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
