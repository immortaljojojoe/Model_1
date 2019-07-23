package scene.Creatures;

import java.awt.*;
import java.util.ArrayList;

public class Creature {
    private ArrayList<Monster> monsters;
    private int NumOfMonsters = 0;

    public Creature() {
        monsters = new ArrayList<>(5);
        monsters.add(new Monster_001Lion());
        NumOfMonsters++;
    }

    public void drawMonsters(Graphics2D g, int offset) {
        for (int i = 0; i < NumOfMonsters; i++) {
            monsters.get(i).drawMonster(g, offset);
        }
    }

}
