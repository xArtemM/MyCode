import weapon.*;

public class Player {

    private final int SLOTSIZE = 6;
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[SLOTSIZE];
        weaponSlots[0] = new Pistol();
        weaponSlots[1] = new Rifle();
        weaponSlots[2] = new RPG();
        weaponSlots[3] = new Slingshot();
        weaponSlots[4] = new Watergun();
        weaponSlots[5] = new Pistol();
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        if (slot >= weaponSlots.length) {
            System.out.println("Такого оружия нет!");
            return;
        }
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }

}
