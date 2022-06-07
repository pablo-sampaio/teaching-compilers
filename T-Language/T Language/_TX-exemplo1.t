
input-set {"a" .. "c"}

program TripleBalance {

start:

   if (not "a") REJECT; 
   write ("A");

advance_aB:

   if ("a") 
      move right;
   else if ("B") 
      move right;

   goto advance_aB:

   if (not "b") REJECT;
   write ("B");

advance_bC:

   if ("b") {
      move right;
      goto advance_bC;
   } else 
   if ("C") { 
      move right;
      goto advance_bC;
   }
   
   if (not "c")
	   REJECT;
   write (C);
   
rewind_to_A:
   
   if ("A") 
      goto rewind_end;
   
   move left;
   goto rewind_to_A;

rewind_end:
   
   move right;

   if ("a") {
      goto start;
   }
   
rewind_to_blank:
   
   if (blank) ACCEPT;

   if (not "B")
      if (not "C")
         REJECT;

   goto rewind_to_blank;

}

