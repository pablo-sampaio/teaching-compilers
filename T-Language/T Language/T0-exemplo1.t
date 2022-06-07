
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%                                              %%
%%  Este programa aceita cadeias na forma w#w,  %%
%%  onde w é uma cadeia do alfabeto {a, b}      %%
%%                                              %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

start:

	if [#] goto verify_markeds
	if [a] goto mark_a
	if [b] goto mark_b
	REJECT

%% marca o símbolo 'a' atual escrevendo 'A' e confere se o
%% primeiro não-marcado após o # é também um 'a', marcando-o com 'A'	
mark_a:

	write [A]
	
	loop_to_sharp_1:
		
		move right
		if-not [#] goto loop_to_sharp_1
		
	loop_to_unmarked_1:
	
		move right
		if [a] goto mark_2nd_a
		if [A] goto loop_to_unmarked_1
		if [B] goto loop_to_unmarked_1
		REJECT

	mark_2nd_a:
	
		write [A]
		
	rewind_to_sharp_1:
		move left
		if-not [#] goto rewind_to_sharp_1
		
	rewind_to_last_marked_1:
		move left
		if [a] goto rewind_to_last_marked_1
		if [b] goto rewind_to_last_marked_1
	
	move right
	
	goto start

%% similar ao mark_a, porém marca o 'b' atual escrevendo 'B' e
%% faz o mesmo com o primeiro não-marcado depois do '#', se for 'b'
mark_b:

	write [B]
	
	loop_to_sharp_2:
		move right
		if-not [#] goto loop_to_sharp_2
		
	loop_to_unmarked_2:
		move right
		if [b] goto mark_2nd_b
		if [A] goto loop_to_unmarked_2
		if [B] goto loop_to_unmarked_2
		REJECT

	mark_2nd_b:
		write [B]
		
	rewind_to_sharp_2:
		move left
		if-not [#] goto rewind_to_sharp_2
		
	rewind_to_last_marked_2:
		move left
		if [a] goto rewind_to_last_marked_2
		if [b] goto rewind_to_last_marked_2
	
	move right
	
	goto start
	

%% verifica se todos os símbolos à direita estão marcados
%% aceita, caso estejam; rejeita, caso contrário
verify_markeds:

	move right
	if [blank] goto accept_label
	if [A] goto verify_markeds
	if [B] goto verify_markeds
	REJECT

accept_label:
	ACCEPT
