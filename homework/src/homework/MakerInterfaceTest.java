package homework;

interface Repairable { 
	
}

class Unit {
	final int MAX_HP;
	int currentHP;
	
	public Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit{
	public GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit {
	public AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	public Tank() {
		super(150);
		currentHP = MAX_HP;
		System.out.println("Tank의 현재 HP는 : " + currentHP + " 입니다.");
	}

	@Override
	public String toString() {
		return "Tank";
	}
	
	
}

class Marine extends GroundUnit {
	public Marine() {
		super(80);
		currentHP = MAX_HP;
		System.out.println("Marine의 현재 HP는 : " + currentHP + " 입니다.");
	}

	@Override
	public String toString() {
		return "Marine";
	}
	
}

class SCV extends GroundUnit implements Repairable {

	public SCV() {
		super(100);
		currentHP = MAX_HP;
		System.out.println("SCV의 현재 HP느 : " + currentHP + " 입니다.");
	}
	
	public void repair(Repairable repairable) {
		if(repairable instanceof Unit) {
			Unit unit = (Unit) repairable;
			unit.currentHP = 100;
			while(unit.currentHP < unit.MAX_HP) {
				unit.currentHP++;
				System.out.print(".");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("\n" + unit + " 수리완료");
		}else {
			System.out.println("수리 불가");
		}
	}

	@Override
	public String toString() {
		return "SCV";
	}
	
}

class DropShip extends AirUnit implements Repairable {

	public DropShip() {
		super(120);
		currentHP = MAX_HP;
		System.out.println("DropShip의 현재 HP는 : " + currentHP + " 입니다.");
	}

	@Override
	public String toString() {
		return "DropShip";
	}
	
	
}

public class MakerInterfaceTest {

	public static void main(String[] args) {
		
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		
		scv.repair(tank);
		scv.repair(dropShip);
		scv.repair(scv);
		
		
	}
	
}