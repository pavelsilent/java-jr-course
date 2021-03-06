package io.github.bael.javacourse.knight;

import io.github.bael.javacourse.knight.chances.BadLuckChance;
import io.github.bael.javacourse.knight.warriors.BlackKnight;
import io.github.bael.javacourse.knight.warriors.Knight;
import io.github.bael.javacourse.knight.warriors.WarriorState;
import org.junit.Assert;
import org.junit.Test;

public class KnightTest {

    /**
     * Проверяем что урон от обычному рыцаря черному рыцарю происходит с удвоенной силой, в отличии от обычного противника
     */
    @Test
    public void checkKnightAttack() {
        WarriorState.WarriorStateBuilder stateBuilder = WarriorState.builder().attackLevel(100)
                .defenceLevel(100).hp(1000).maxHP(1000).strength(100).level(1);
        Knight knight = new Knight(stateBuilder.build());
        BlackKnight blackKnight = new BlackKnight(stateBuilder.build());
        Knight whiteknight = new Knight(stateBuilder.build());

        BadLuckChance chance = new BadLuckChance();

        knight.attackEnemy(chance, blackKnight);
        // урон удвоен
        Assert.assertEquals(800, blackKnight.getState().getHP());

        knight.attackEnemy(chance, whiteknight);
        // урон обычный
        Assert.assertEquals(900, whiteknight.getState().getHP());

    }

}