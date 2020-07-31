package Game;

public class Cell {
	
	int value;

	public Cell(int value) {
		this.value = value;
	}
	public boolean isGreen(){
		if(this.value > 0){
			return true;
		} return false;
	};
	
}
