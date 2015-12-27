package RecursionAndDP;

public class Box {
	public int width;
	public int height;
	public int depth;
	
	public Box(int x, int y, int z){
		this.width = x;
		this.depth = y;
		this.height = z;
	}
	
	public boolean canBeAbove(Box b2){
		if(b2 == null) return true;
		return (this.width < b2.width &&
				this.height < b2.height &&
				this.depth < b2.depth);
	}
}
