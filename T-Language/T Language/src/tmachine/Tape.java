package tmachine;

import java.io.IOException;
import java.io.InputStream;


public class Tape {
	private Block leftMost;
	
	private Block currentBlock; //the tape is allocated in blocks, organized as a doubly-linked list
	private int currentIndex;   //relative index in the current block
	
	private static final int DEFAULT_BLOCK_SIZE = 4;

	public Tape() {
		currentIndex = 0;
		leftMost = currentBlock = new Block(DEFAULT_BLOCK_SIZE);
	}
	
	public Tape(InputStream initialContent, boolean unicode) throws IOException {
		currentIndex = 1; // first position is blank
		leftMost = currentBlock = new Block(initialContent.available() + 2);
		
		if (unicode) {
			throw new UnsupportedOperationException("Unicode still unsupported.");
		
		} else {
			int index = currentIndex; 
			int c = initialContent.read();
			
			while (c != -1) {
				currentBlock.set(index, (char)c);
				index ++;
				c = initialContent.read();
			}		
		}
		
	}
	
	public char readSymbol() {
		return currentBlock.get(currentIndex);
	}
	
	public void writeSymbol(char symbol) {
		currentBlock.set(currentIndex, symbol);
	}
	
	public void move(Direction direction) {
		if (direction == Direction.LEFT) {
			currentIndex --;
			if (currentIndex < 0) {
				currentBlock = currentBlock.goLeft();
				currentIndex = currentBlock.getSize() - 1;
			}
		
		} else if (direction == Direction.RIGHT) {
			currentIndex ++;
			if (currentIndex >= currentBlock.getSize()) {
				currentBlock = currentBlock.goRight();
				currentIndex = 0;
			}
		}
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		Block block = leftMost;
		
		do {
			if (block == currentBlock) {
				string.append(block.print(0,currentIndex-1));
				string.append('(');
				string.append(block.get(currentIndex));
				string.append(')');
				string.append(block.print(currentIndex+1,block.getSize()-1));
			} else {
				string.append(block.content);
			}

			block = block.right;
		
		} while (block != null);
		
		return string.toString();
	}

	
	class Block {
		private char[] content;
		
		private Block left;
		private Block right;
		
		Block(int size) {
			content = new char[size];
		}
		
		Block(int size, Block l, Block r) {
			content = new char[size];
			left = l;
			right = r;
		}
		
		char get(int index) {
			return content[index];
		}
		void set(int index, char c) {
			content[index] = c;
		}
		int getSize() {
			return content.length;
		}
		
		
		Block goRight() {
			if (right == null) {
				right = new Block(DEFAULT_BLOCK_SIZE, this, null);
			}
			return right;
		}
		Block goLeft() {
			if (left == null) {
				left = new Block(DEFAULT_BLOCK_SIZE, null, this);
				if (leftMost == this) {
					leftMost = left;
				}
			}
			return left;
		}

		String print() {
			String string = new String(content); 
			return string.replace((char)0, ' ');
		}
		String print(int from, int to) {
			String string = new String(content, from, (to-from)+1);
			return string.replace((char)0, ' ');
		}
		
	}

}

