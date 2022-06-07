

operate {

	while (not #) {
		if (a) {
			write(A);
			advance-to(#);
			advance-to(a or b);
			check(a);
			write(A);
			back-to(#);
			back-to(A);
			move right;
			
		} else if (b) {
			write(B);
			advance-to(#);
			advance-to(a or b);
			check(b);
			write(B);
			back-to(#);
			back-to(B);
			move right;
		
		} else {
			REJECT;

		}
	}
	
	advance-while(A or B);
	check(blank);
	ACCEPT;

}
