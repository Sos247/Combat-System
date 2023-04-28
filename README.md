Main Logic -> TURN BASE battles, one path, one boss, enemies

Classes - > 3 Classes ( BARBARIAN, ROGUE, WIZARD )


CLASS BARBARIAN has 	HP, ARMOR, DAMAGE, RESOURCE(RAGE),  INITIATIVE 	& 3 ABILLITIES ( 1 BASIC & 2 ABILS)
CLASS ROGUE 	has 	HP, ARMOR, DAMAGE, RESOURCE(ENERGY),INITIATIVE 	& 3 ABILLITIES ( 1 BASIC & 2 ABILS)
CLASS WIZARD	has 	HP, ARMOR, DAMAGE, RESOURCE(MANA),  INITIATIVE	& 3 ABILLITIES ( 1 BASIC & 2 ABILS)


RAGE-> 	 GENERATES WITH BASIC ATTACKS
ENERGY-> GENERATES EACH TURN 
MANA-> 	 GENERATES WITH BASIC ATTACKS


Difficulty -> 3 Difficulties ( Easy(5 Steps), Normal(10 steps), Hard(15 steps) )

The Adventure - > Think of it as Train Stations , your hero board the train for X steps, on each step you encounter one of the following
		1)Enemy
		2)Item
		3)Civilian
		4)Nothing
		Final Step)Boss

BATTLE SYSTEM ( Turn Based )

1st Step) Initiative Check to see who attacks first
2nd Step) Start of Turn (turn repeats while your hp and enemy hp > 0)
3rd Step) Print your and enemy stats 
4th Step) Your Side of Turn
		Status effects from buffs or debuffs trigger 
		You can choose in your turn between attacking or using an item(if its not empty)
			For Attack-> ability - Defender Armor.
				     enables an effect if exist
				     you mana, rage, energy = -ability mana cost
				     checks if enemy hp > 0
				     ends your side of turn or if enemy dies end the battle

			For Inventory -> Choose an Item to use
					 ends your side of turn
	  Enemy Side of turn
		Status Effects from buffs and debuffs trigger
		Enemy chooses an attack
			For Attack-> ability - your armor
				     enable status effects if exits
				     mana, rage, energy = -ability mana cost
				     checks if your hp > 0
				     end enemy side of turn or game if you die
