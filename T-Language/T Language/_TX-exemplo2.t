
input-set {a..c}

check (c : condition) {
   if (!c) REJECT;
}

main {
	
   start:

   check (a)
   write(A);

   while (a | B) do
      move right;

   check (b);
   write (B);
   
   while (b | C)
      move right;

   check (c);
   write (C);
   
   while (not A) 
      move left;

   move right;

   if (a) {
      goto start;
   }
   
   while (not blank) 
      check (B | C);

   ACCEPT;

}
