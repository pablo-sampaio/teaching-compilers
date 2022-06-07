package tlanguage.version0.tree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import tmachine.Tape;


public class Program {
	
	private List<Command> commands; 
	
	public Program(List<Command> list) {
		commands = list;
	}
	
	public boolean verify() {
		boolean result = true; 
		
		HashMap<String,Label> labels = new HashMap<String,Label>();
		String labelName;
		Command previous = new Label("$$");  //artificio
		
		for (Command c : commands) {
			
			if (c instanceof Label) {
				labelName = ((Label)c).getName();
				
				if (labels.containsKey(labelName)) {
					System.out.println("Erro: Label duplicado - \"" + labelName + "\"");
					result = false;
				} else {
					labels.put(labelName, (Label)c);
				}
			}
			
			previous.setFollowing(c);
			previous = c;			
		}
		
		for (Command c : commands) {
			result &= c.verify(labels);
		}
		
		return result;
	}
	
	public boolean run(String input) throws IOException {
		Tape tape = new Tape(new ByteArrayInputStream(input.getBytes()), false);

		Command current = null;
		Command next = commands.get(0);

		System.out.println(tape);
		
		do {
			//System.out.println(next);
			
			current = next;
			next = current.run(tape);
			
			System.out.println(tape);
		} while (next != null);

		return ((Decision)current).isAccept();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (Command c : commands) {
			if (c instanceof Label) {
				builder.append(c);
			} else {
				builder.append('\t');
				builder.append(c);
			}
			builder.append('\n');
		}
		
		return builder.toString();
	}

}
