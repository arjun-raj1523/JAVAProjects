public class User {

	public static void sort(int[] args){
		 int n = args.length;
		                int temp = 0;
		                for(int i=0; i < n; i++){
		                        for(int j=1; j < (n-i); j++){
		                                if(args[j-1] > args[j]){
		                                        //swap the numbers
		                                        temp = args[j-1];
		                                        args[j-1] = args[j];		
		                                        args[j] = temp;
		                                }
		                        }	
		                }
		                for(int i=0; i < n; i++)
		                	System.out.println(args[i]);
		        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[]=new int[args.length];
		
		for(int i=0;i<args.length;i++)
			{   
				array[i]=Integer.parseInt(args[i]);
			
			}
		sort(array);
	}

}
