import java.io.*;
import java.util.*;

public class Trashfighters {
    public static class Character {
        private String name; private String wpn; private String armor;
        private int lvl; private int hp; private int maxhp; private int pow; private int def; private int spd; private int rec; private int mana; private int maxmana; private int exp; private int maxpow; private int maxdef; private int maxspd;
       
        // Constructor
        public Character(String name, String wpn, String armor, int lvl, int hp, int maxhp, int pow, int def, int spd, int rec, int mana, int maxmana, int exp, int maxpow, int maxdef, int maxspd) {
            this.name = name;
            this.wpn = wpn;
            this.armor = armor;
            this.lvl = lvl;
            this.hp = hp;
            this.maxhp = maxhp;
            this.pow = pow;
            this.def = def;
            this.spd = spd;
            this.rec = rec;
            this.mana = mana;
            this.maxmana = maxmana;
            this.exp = exp;
            this.maxpow = maxpow;
            this.maxdef = maxdef;
            this.maxspd = maxspd;
        }
    
        public String getName() {return name;}
        public void setName(String name) { this.name = name;}
    
        public String getWpn() {return wpn;}
        public void setWpn(String wpn) {this.wpn = wpn;}

        public String getArmor() {return armor;}
        public void setArmor(String armor) {this.armor = armor;}
    
        public int getLvl() {return lvl;}
        public void setLvl(int lvl) {this.lvl = lvl;}
    
        public int getHp() {return hp;}
        public void setHp(int hp) {this.hp = hp;}
    
        public int getMaxhp() {return maxhp;}
        public void setMaxhp(int maxhp) {this.maxhp = maxhp;}
    
        public int getPow() {return pow;}
        public void setPow(int pow) {this.pow = pow;}
    
        public int getDef() {return def;}
        public void setDef(int def) {this.def = def;}
    
        public int getSpd() {return spd;}
        public void setSpd(int spd) {this.spd = spd;}
    
        public int getRec() {return rec;}
        public void setRec(int rec) {this.rec = rec;}
    
        public int getMana() { return mana;}
        public void setMana(int mana) {this.mana = mana;}
    
        public int getMaxmana() {return maxmana;}
        public void setMaxmana(int maxmana) {this.maxmana = maxmana;}
    
        public int getExp() {return exp;}
        public void setExp(int exp) {this.exp = exp;}
    
        public int getMaxpow() {return maxpow;}
        public void setMaxpow(int maxpow) {this.maxpow = maxpow;}
    
        public int getMaxdef() {return maxdef;}
        public void setMaxdef(int maxdef) {this.maxdef = maxdef;}
    
        public int getMaxspd() {return maxspd;}
        public void setMaxspd(int maxspd) {this.maxspd = maxspd;}
    }

    public static class Extra {
        private String[] skills;
        private String[] items;
        private String difficulty;
        private String mode;
        private int hpass;
        private int money;
    
        // Constructor
        public Extra(String[] skills, String[] items, String difficulty, String mode, int hpass, int money) {
            this.skills = skills;
            this.items = items; // Initialize the items array
            this.difficulty = difficulty;
            this.mode = mode;
            this.hpass = hpass;
            this.money = money;
        }
    
        public String[] getSkills() {return skills; }
        public void setSkills(String[] skills) {this.skills = skills;}

        public String[] getItems() {return items;}
        public void setItems(String[] items) {this.items = items;}
    
        public String getDifficulty() {return difficulty;}
        public void setDifficulty(String difficulty) {this.difficulty = difficulty;}
    
        public String getMode() {return mode;}
        public void setMode(String mode) {this.mode = mode;}
    
        public int getHpass() {return hpass;}
        public void setHpass(int hpass) {this.hpass = hpass;}

        public int getMoney() {return money;}
        public void setMoney(int money) {this.money = money;}

    }
    
public static void main(String[] args) throws IOException{
    boolean game = true;
    String choice;
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    gameload();
    while (game) {
        System.out.println("=======================================================================\r\n" + 
                            "||                                                                   ||\r\n" + 
                            "||  _______            _     ______ _       _     _                  ||\r\n" + 
                            "|| |__   __|          | |   |  ____(_)     | |   | |                 ||\r\n" + 
                            "||    | |_ __ __ _ ___| |__ | |__   _  __ _| |__ | |_ ___ _ __ ___   ||\r\n" + 
                            "||    | | '__/ _` / __| '_ \\|  __| | |/ _` | '_ \\| __/ _ \\ '__/ __|  ||\r\n" +
                            "||    | | | | (_| \\__ \\ | | | |    | | (_| | | | | ||  __/ |  \\__ \\  ||\r\n" +
                            "||    |_|_|  \\__,_|___/_| |_|_|    |_|\\__, |_| |_|\\__\\___|_|  |___/  ||\r\n" +
                            "||                                     __/ |                         ||\r\n" +
                            "||                                    |___/                          ||\r\n" +
                            "=======================================================================\r\n" +
                            "------------------------------VERSION 1.1------------------------------\n");

        System.out.println("1. Adventure Mode");
        System.out.println("2. Survival Mode");
        System.out.println("3. Quit");

        System.out.print("System: Enter your choice -- ");
        choice = rd.readLine();

        System.out.println("Loading...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gamePause();
        clearConsole();

        Character player = new Character("Johnny", "Broomstick", "School Uniform", 1, 30, 30, 4, 1, 5, 20, 2, 2, 0, 20, 20, 20);
        String[] skills = {"N/A", "N/A", "N/A"}; // Initialize skills array
        String[] items = {"N/A", "N/A", "N/A"}; // Initialize items array
        Extra playerextra = new Extra(skills, items, "Easy", "Normal", 0, 0);

        if ("1".equals(choice)) {
            playerextra.setMode("Game");
            firstPart(player, playerextra, choice);
            narrateStory();
            
            mainhub(player, playerextra);

        } else if ("2".equals(choice)) {
            playerextra.setMode("Survival");
            playerextra.setMoney(0);
            firstPart(player, playerextra, choice);

            System.out.print("System: Are you familiar with the Survival Mode? (Y/N): ");
            choice = rd.readLine();

            if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice)) {
                System.out.println("System: Enjoy Survival Mode!");
            } else {
                System.out.println("System: The gamemode will pit you against 10 fights in a row, without stopping or exploration.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("System: Don't worry, you will still have your blessings and levelling up.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("System: In addition, mana and HP will be fully recovered after every battle.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

			gamePause();
            survival(player, playerextra);

            clearConsole();
            System.out.println("\nPrincipal: You have slain the rat king, student " + player.getName() + "...");
            System.out.println("\nPrincipal: Good job, you have used your critical and logical thinking!");
            System.out.println("\nPrincipal: Congratulations on beating the Survival Minigame on " + playerextra.getDifficulty() + ".");
            System.out.println("System: Thank you for playing Trashfighters Version 1.1!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;

        } else if ("3".equals(choice)) {
            System.out.println("System: Thank you for playing Trashfighters Version 1.1!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
    }

    rd.close();
}

private static void narrateStory() {
    System.out.println("Narrator: Once upon a time, there was a creative young boy named Johnny Thor Dela Cruz who had notoriously bad grades...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Narrator: The boy was then granted another chance by the principal, with the principal promising the boy that he would pass 8th grade if he were to clean the school as community service...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Narrator: Johnny accepted the proposal posthaste, but little did the boy know, it turns out it wasn't just ordinary trash and grime he has to clean...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Narrator: The boy has to fight trash-themed monsters, and they were no slouch either...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Narrator: So the boy set out, to clean the school...");
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    gamePause();
}

public static void gameload() {
    Random random = new Random();
    int delay;

    for (int load = 0; load < 100;) {
        System.out.println("--LOADING--\n\n\n\n\n");
        delay = 1 + random.nextInt(25);
        System.out.println(load + " / 100");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        load += delay;
        clearConsole();
    }

    System.out.println("--LOADING--\n\n\n\n\n");
    System.out.println("100 / 100");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    clearConsole();
}

public static void gamePause() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Press enter to continue . . .");
    String pause = sc.nextLine();
}

public static void clearConsole() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.println("\n================================================\n");
        }
    } catch (IOException | InterruptedException ex) {
        ex.printStackTrace();
    }
}

public static Character firstPart(Character player, Extra playerextra, String choice) throws IOException {
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    String diff;

    while (true) {
        if (choice.equals("1")) {
            player.setName("Johnny");
            System.out.print("\n???: Enter difficulty:\n1. Easy\n2. Medium\n3. Hard\nEnter Difficulty: ");
            diff = rd.readLine();
        } else {
            System.out.print("???: What is your name?: ");
            player.setName(rd.readLine());
            System.out.print("\n???: Enter difficulty:\n1. Easy\n2. Medium\n3. Hard\nEnter Difficulty: ");
            diff = rd.readLine();
        }
        if (diff.equals("1") || diff.equalsIgnoreCase("easy")) {
            System.out.println("Turning on easy mode...");
            player.setMaxhp(35);
            player.setHp(35);
            playerextra.setHpass(1);
            playerextra.setMoney(150);
            break;
        } else if (diff.equals("2") || diff.equalsIgnoreCase("medium")) {
            System.out.println("Turning on medium mode...");
            playerextra.setMoney(150);
            break;
        } else if (diff.equals("3") || diff.equalsIgnoreCase("hard")) {
            System.out.println("Turning on hard mode...");
            player.setSpd(3);
            playerextra.setMoney(75);
            break;
        } else {
            System.out.println("Invalid difficulty. Please enter a valid option.");
        }
    }

    gamePause();
    clearConsole();

    playerextra.setDifficulty(diff);
    return player;
}

public static Character survival(Character player, Extra playerextra) throws IOException{
    int floor = 1;

    //level 1
    System.out.println("----Floor " + floor + "----");
    Character trashman = new Character("Trashman", "Stick", "N/A", 1, 25, 25, 3, 0, 4, 5, 0, 0, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashman);
    floor++;
    player = afterBattle(player, playerextra, trashman);
    player = blessing(player, playerextra, floor);

    //level 2
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character trashmanL2 = new Character("Trashman", "Stick", "N/A", 2, 30, 30, 4, 1, 4, 5, 0, 0, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashmanL2);
    player = afterBattle(player, playerextra, trashmanL2);
    player = blessing(player, playerextra, floor);

    //level 3
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character trashmanL3 = new Character("Trashman", "Spear", "Trash Tunic", 3, 35, 35, 4, 3, 5, 10, 1, 1, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashmanL3);
    player = afterBattle(player, playerextra, trashmanL3);
    player = blessing(player, playerextra, floor);

    //level 4
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character trashsoldier = new Character("Trash Soldier", "Spear", "N/A", 4, 40, 40, 4, 3, 5, 10, 1, 1, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashsoldier);
    player = afterBattle(player, playerextra, trashsoldier);
    player = blessing(player, playerextra, floor);

    //level 5
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character trashsoldierL2 = new Character("Trash Soldier", "Spear", "Trash Tunic", 5, 45, 45, 5, 4, 5, 10, 1, 1, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashsoldierL2);
    player = afterBattle(player, playerextra, trashsoldierL2);
    player = blessing(player, playerextra, floor);

    //level 6
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character trashsoldierL3 = new Character("Trash Soldier", "Sword", "Waste Armor", 6, 50, 50, 5, 5, 6, 10, 1, 1, 0, 0, 0, 0);
    battleSimulation(player, playerextra, trashsoldierL3);
    player = afterBattle(player, playerextra, trashsoldierL3);
    player = blessing(player, playerextra, floor);

    //level 7
    System.out.println("----Floor " + floor + "----");
    floor++;

    Character ratmage = new Character("Rat Mage", "Reekburst", "Trash Tunic", 7, 50, 50, 4, 5, 3, 10, 2, 2, 0, 0, 0, 0);
    battleSimulation(player, playerextra, ratmage);
    player = afterBattle(player, playerextra, ratmage);
    player = blessing(player, playerextra, floor);

    //level 8
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character ratmageL2 = new Character("Rat Mage", "Reekburst", "Rubbish Robe", 8, 50, 50, 5, 6, 3, 15, 2, 2, 0, 0, 0, 0);
    battleSimulation(player, playerextra, ratmageL2);
    player = afterBattle(player, playerextra, ratmageL2);
    player = blessing(player, playerextra, floor);

    //level 9
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character ratmageL3 = new Character("Rat Mage", "Reekburst", "Rubbish Robe", 9, 60, 60, 6, 9, 3, 15, 2, 2, 0, 0, 0, 0);
    battleSimulation(player, playerextra, ratmageL3);
    player = afterBattle(player, playerextra, ratmageL3);
    player = blessing(player, playerextra, floor);


    //level 10
    System.out.println("----Floor " + floor + "----");
    floor++;
    Character ratking = new Character("Rat King", "Rat-tling", "Rubbish Robe", 10, 65, 65, 7, 15, 8, 20, 2, 2, 0, 0, 0, 0);
    battleSimulation(player, playerextra, ratking);

    return player;
}

public static Character battleSimulation(Character player, Extra playerextra, Character enemy) throws IOException {
    boolean battle = true;
    int round = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("\n\n" + player.getName() + " was challenged by " + enemy.getName() + "!\n");

    if (playerextra.getDifficulty().equals("3") || playerextra.getDifficulty().equalsIgnoreCase("hard")) {
        enemy.setMaxhp(enemy.getMaxhp() + (player.getLvl() - 1) * 5);
        enemy.setHp(enemy.getMaxhp());
        enemy.setPow(enemy.getPow() + player.getLvl() - 1);
        enemy.setDef(enemy.getDef() + player.getLvl() - 1);
        enemy.setSpd(enemy.getSpd() + player.getLvl());
        enemy.setRec(enemy.getRec() + (player.getLvl() - 1) * 5);
        enemy.setMaxmana(enemy.getMaxmana() + 1);
        enemy.setMana(enemy.getMaxmana());
        player.setMaxpow(15);
        player.setMaxdef(15);
        player.setMaxspd(15);
        playerextra.setDifficulty("Hard");
    } else if (playerextra.getDifficulty().equals("2") || playerextra.getDifficulty().equalsIgnoreCase("medium")) {
        enemy.setPow(enemy.getPow() + player.getLvl());
        enemy.setDef(enemy.getDef() + player.getLvl() - 1);
        enemy.setSpd(enemy.getSpd() + player.getLvl());
        player.setMaxpow(20);
        player.setMaxdef(20);
        player.setMaxspd(20);
        playerextra.setDifficulty("Medium");
    } else if (playerextra.getDifficulty().equals("1") || playerextra.getDifficulty().equalsIgnoreCase("easy")) {
        player.setPow(player.getPow() + 1);
        player.setDef(player.getDef() + 1);
        player.setMaxpow(25);
        player.setMaxdef(25);
        player.setMaxspd(25);
        playerextra.setDifficulty("Hard");
    }

    if (playerextra.getMode().equals("Survival")) {
        player.setHp(player.getMaxhp());
        player.setMana(player.getMaxmana());
    }

    while (battle) {
        clearConsole();
        System.out.println("--Round " + (++round) + "--\n\n");

        ascii(enemy.getName());


        System.out.println(enemy.getName() + "'s HP: " + enemy.getHp() + " / " + enemy.getMaxhp() + " | MANA: " + enemy.getMana() + " / " + enemy.getMaxmana() + " | LVL: " + enemy.getLvl());
        System.out.println(player.getName() + "'s HP: " + player.getHp() + " / " + player.getMaxhp() + " | MANA: " + player.getMana() + " / " + player.getMaxmana() + " | LVL: " + player.getLvl());

        System.out.println("What do you want to do? \n");
        System.out.print("1. Attack\n2. Stats\n3. Heal\n");
        if (playerextra.getMode().equals("Game")) {
            System.out.println("4. Items\n");
        }
        System.out.print(player.getName() + ": ");
        String choice = reader.readLine();

        if (choice.equals("1")) {
            if (playerextra.skills[0].equals("N/A") && playerextra.skills[1].equals("N/A") && playerextra.skills[2].equals("N/A")) {
                attackSimulation(player, playerextra, enemy);
            } else {
                int option = 1;
                System.out.println("What would you like to do?\n");
                System.out.println(option + ". Use your " + player.wpn + " to attack - COSTS NO MANA");
                option++;
                if (!playerextra.skills[0].equals("N/A")) {
                    System.out.println(option + ". Use your \"" + playerextra.skills[0] + "\" skill - Makes the user instantly go last. Deals damage equal to damage taken (COSTS 1 MANA).");
                    option++;
                }
                if (!playerextra.skills[1].equals("N/A")) {
                    System.out.println(option + ". Use your \"" + playerextra.skills[1] + "\" skill - Deals damage ignoring the opponent's defense. Costs 1 mana.");
                    option++;
                }
                if (!playerextra.skills[2].equals("N/A")) {
                    System.out.println(option + ". Use your \"" + playerextra.skills[2] + "\" skill - Makes the user instantly go last. Deals twice the damage. Costs 2 mana.");
                    option++;
                }
                System.out.println("a. Go Back.");
                System.out.print(player.name + ": ");
                choice = reader.readLine();

                if (choice.equals("1")) {
                    attackSimulation(player, playerextra, enemy);
                } else if (choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                    skillSimulation(player, playerextra, enemy, choice);
                } else if (choice.equals("a")) {
                    round--;
                } else {
                    System.out.println("Not an action!\n");
                    round--;
                }
            }
        } else if (choice.equals("2")) {
            clearConsole();
            checkStats(player, playerextra);
            round--;
        } else if (choice.equals("3")) {
            if (player.getMana() <= 0) {
                System.out.println("You have run out of mana, you cannot heal!\n");
                round--;
            } else {
                player.setHp(player.getHp() + player.getRec());
                player.setMana(player.getMana() - 1);
            
                if (player.getHp() > player.getMaxhp()) {
                    System.out.println(player.getName() + " healed back to max HP!\n");
                    player.setHp(player.getMaxhp());
                } else {
                    System.out.println(player.getName() + " healed " + player.getRec() + " damage!\n");
                }
            
                int res = resistance(player.getArmor(), player.getLvl());
                int dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
                if (dmg < 1) {
                    dmg = 1;
                }
                player.setHp(player.getHp() - dmg);
            
                System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");
            
                if (player.getHp() > player.getMaxhp()) {
                    player.setHp(player.getMaxhp());
                }
            }
        } else if (choice.equals("4") && playerextra.getMode().equals("Game")) {
            itemMenu(player, playerextra);
            System.out.println();

            int res = resistance(player.getArmor(), player.getLvl());
            int dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
            if (dmg < 1) {
                dmg = 1;
            }
            player.setHp(player.getHp() - dmg);
        
            System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");
        
            if (player.getHp() > player.getMaxhp()) {
                player.setHp(player.getMaxhp());
            }
        } else {
            System.out.println("Not an action!\n");
            round--;
        }

        if (enemy.getMaxmana() > 0 && enemy.getHp() <= (enemy.getMaxhp() / 2) && enemy.getMana() > 0 && enemy.getRec() > 0 && enemy.getHp() > 0) {
	        enemy.setHp(enemy.getHp() + enemy.getRec());
	        System.out.println(enemy.getName() + " recovered " + enemy.getRec() + " HP in exchange for 1 MANA\n");
	        enemy.setMana(enemy.getMana() - 1);
	
	        if (enemy.getHp() > enemy.getMaxhp()) {
	            enemy.setHp(enemy.getMaxhp());
	        }
	        
	    } else if (enemy.getHp() <= (enemy.getMaxhp() / 2)) {
	       System.out.println("The " + enemy.getName() + " looks like its struggling to fight...\n");
	    } else if (enemy.getMaxmana() > 0 && enemy.getMana() < enemy.getMaxmana()) {
	       System.out.println("The " + enemy.getName() + " looks weakened...\n");
	    } else if (enemy.getMaxmana() > 0){
	        System.out.println("The " + enemy.getName() + " looks raring to go...\n");
	    }

        if (enemy.getHp() <= 0) {
            System.out.println(enemy.getName() + " was slain\n");
            battle = false;
        }

        gamePause();
    }
    return player;
}

public static int attackSimulation(Character player, Extra playerextra, Character enemy) throws IOException {
    if (player.getSpd() >= enemy.getSpd()) {
        // Combat logic for character attacking first
        int res = resistance(enemy.getArmor(), enemy.getLvl());
        int dmg = damage(player.getPow(), player.getWpn(), enemy.getDef(), player.getLvl()) - res;
        if (dmg < 1) {dmg = 1;}
        enemy.setHp(enemy.getHp() - dmg);
        System.out.println(player.getName() + " dealt " + dmg + " damage!");
        if (enemy.hp <= 0) {return 1;}

        res = resistance(player.getArmor(), player.getLvl());
        dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
        if (dmg < 1) {dmg = 1;}
        player.setHp(player.getHp() - dmg);
        System.out.println(enemy.getName() + " dealt " + dmg + " damage!");
        if (player.getHp() <= 0) {
            System.out.println(player.getName() + " was slain");
            gameover();
        }
    } else {
        // Combat logic for monster attacking first
        int res = resistance(player.getArmor(), player.getLvl());
        int dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
        if (dmg < 1) {dmg = 1;}
        player.setHp(player.getHp() - dmg);
        System.out.println(enemy.getName() + " dealt " + dmg + " damage!");
        if (player.getHp() <= 0) {
            System.out.println(player.getName() + " was slain");
            gameover();
        }

        res = resistance(enemy.getArmor(), enemy.getLvl());
        dmg = damage(player.getPow(), player.getWpn(), enemy.getDef(), player.getLvl()) - res;
        if (dmg < 1) {dmg = 1;}
        enemy.setHp(enemy.getHp() - dmg);
        System.out.println(player.getName() + " dealt " + dmg + " damage!");
    }

    return player.getHp();
}

static int skillSimulation(Character player, Extra playerextra, Character enemy, String choice) throws IOException {
    int dmg;
    Random random = new Random();
    int bonus = random.nextInt(player.getLvl());

    if ("2".equals(choice) && "Reversal".equals(playerextra.skills[0])) {
        if (player.getMana() <= 0) {
            System.out.println("You have run out of mana, you cannot use \"Reversal\"!\n");
            System.out.println("You have can't use skill, initiating attack out of instinct!\n");
            attackSimulation(player, playerextra, enemy);
        } else {
            System.out.println(player.name + " is waiting for the opponent's move!\n");
            int res = resistance(player.getArmor(), player.getLvl());
            dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
            if (dmg < 1) {dmg = 1;}
            player.setHp(player.getHp() - dmg);
            if (player.hp <= 0) {
                System.out.println(player.name + " was slain\n");
                gameover();
            }
            System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");

            res = resistance(player.getArmor(), player.getLvl());
            dmg = (player.getMaxhp() - player.getHp()) - enemy.getDef() - res;
            if (dmg < 1) {dmg = 1;}
            enemy.setHp(enemy.getHp() - dmg);
            System.out.println(player.name + " dealt " + dmg + " damage!\n");
            if (enemy.getHp() <= 0) {return 1;}
            player.setMana(player.getMana() - 1);
        }
    } else if ("4".equals(choice) && "Heavy Impact".equals(playerextra.skills[1])) {
        if (player.getMana() <= 0) {
            System.out.println("You have run out of mana, you cannot use \"Heavy Impact\"!\n");
            System.out.println("You have can't use skill, initiating attack out of instinct!\n");
            attackSimulation(player, playerextra, enemy);
        } else {
            System.out.println(player.getName() + " is charging \"Heavy Impact\"!\n");
            int res = resistance(player.getArmor(), player.getLvl());
            dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - 1;
            if (dmg < 1) {dmg = 1;}
            player.setHp(player.getHp() - dmg);
            System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");
            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " was slain\n");
                gameover();
            }

            res = resistance(enemy.getArmor(), enemy.getLvl());
            dmg = damage(player.getPow(), player.getWpn(), enemy.getDef(), player.getLvl()) * 2 - res;
            if (dmg < 1) {dmg = 1;}
            enemy.setHp(enemy.getHp() - dmg);
            System.out.println(player.getHp() + " dealt " + dmg + " damage!\n");
            if (enemy.hp <= 0) {return 1;}
            player.setMana(player.getMana() - 2);
        }
    } else if ("3".equals(choice) && "Piercing Thrust".equals(playerextra.skills[2])) {
        if (player.getMana() <= 0) {
            System.out.println("You have run out of mana, you cannot use \"Piercing Thrust\"!\n");
            System.out.println("You have can't use skill, initiating attack out of instinct!\n");
            attackSimulation(player, playerextra, enemy);
        } else {
            if (player.getSpd() >= enemy.getSpd()) {
                dmg = player.pow + player.lvl + bonus;
                if (dmg < 1) {dmg = 1;}
                enemy.setHp(enemy.getHp() - dmg);
                System.out.println(player.getName() + " dealt " + dmg + " damage!\n");
                if (enemy.hp <= 0) {return 1;}

                int res = resistance(player.getArmor(), enemy.getLvl());
                dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
                if (dmg < 1) {dmg = 1;}
                player.setHp(player.getHp() - dmg);
                if (player.getHp() <= 0) {
                    System.out.println(player.getName() + " was slain\n");
                    gameover();
                }
                System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");

            } else {
                int res = resistance(player.getArmor(), enemy.getLvl());
                dmg = damage(enemy.getPow(), enemy.getWpn(), player.getDef(), enemy.getLvl()) - res;
                if (dmg < 1) {dmg = 1;}
                player.setHp(enemy.getHp() - dmg);
                System.out.println(enemy.getName() + " dealt " + dmg + " damage!\n");
                if (player.getHp() <= 0) {
                    System.out.println(player.getName() + " was slain\n");
                    gameover();
                }

                dmg = player.getPow() + player.getLvl() + bonus;
                if (dmg < 1) {dmg = 1;}
                enemy.setHp(enemy.getHp() - dmg);
                System.out.println(player.getName() + " dealt " + dmg + " damage!\n");
                if (enemy.getHp() <= 0) {return 1;}
            }
            player.setMana(player.getMana() - dmg);
        }
    } else {
        System.out.println("You have no skills, initiating attack!\n");
        attackSimulation(player, playerextra, enemy);
    }
    return 0;
}

public static int damage(int atk, String wpn, int def, int lvl) {
    int dmg, bonus;
    Random random = new Random();

    if (wpn.equals("Stick") || wpn.equals("Broomstick")) {
        dmg = atk + lvl;
    } else if (wpn.equals("Sword") || wpn.equals("Mop")) {
        dmg = atk * 2 + lvl;
    } else if (wpn.equals("Spear")) {
        dmg = atk * 2 + 2;
    } else if (wpn.equals("Vacuum Cleaner")) {
        System.out.println("The hero used the vacuum cleaner!");
        dmg = atk * 3;
    } else if (wpn.equals("Reekburst")) {
        dmg = atk * 2 + 3;
    } else if (wpn.equals("Rat-tling")) {
        System.out.println("The Rat King used Rat-tling!");
        dmg = atk * 2 + 5;
    } else {
        dmg = atk;
    }

    bonus = random.nextInt(lvl);
    return dmg + bonus - def;
}

public static int resistance(String armor, int lvl) {
    int def;

    if (armor.equals("School Uniform") || armor.equals("Trash Tunic")) {
        def = lvl - 1;
    } else if (armor.equals("Waste Armor")) {
        def = lvl;
    } else if (armor.equals("PE Uniform") || armor.equals("Rubbish Robe")) {
        def = lvl + 2;
    } else {
        def = 0;
    }

    return def;
}

public static void gameover() throws IOException{
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    String choice;

    clearConsole();
    ascii("Principal");
    System.out.println("Principal: You have lost the battle... Try better next time.");
    System.out.print("Principal: Would you like to try again? (Y/N): ");
    choice = rd.readLine();

    if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
        gamePause(); clearConsole();
        main(null);
    } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
        System.exit(0);
    } else {gameover();}
}

public static Character blessing(Character player, Extra playerextra, int floor) throws IOException {
    clearConsole();
    String bless;
    boolean proceed = false;

    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    while (!proceed) {
        clearConsole();
        ascii("Principal");
        System.out.println("Principal: Welcome, " + player.getName() + "...\n");
        System.out.println("Principal: For cleaning up trash in the school, I shall give you an incentives! Choose wisely...\n");
        System.out.println("1. Grant +1 to ATK, DEF, and SPD\n");
        System.out.println("2. Increased HP, MANA and recovery\n");

        if (playerextra.mode.equals("Survival")) {
            if (player.getWpn().equals("Broomstick")) {
                System.out.println("3. Grant " + player.getName() + " a better cleaning tool.\n");
            } else if (player.wpn.equals("Mop") && !player.wpn.equals("Vacuum Cleaner") && floor > 8) {
                System.out.println("3. Grant " + player.getName() + " the cleaner of legends.\n");
            } else if (player.armor.equals("School Uniform") && floor > 5) {
                System.out.println("3. Grant " + player.getName() + " the best schoolwear.\n");
            } else {
                System.out.println("3. Massively increase Attack\n");
            }
        }

        System.out.println("Principal: Enter your choice, student...\n");
        System.out.print(player.name + "'s choice: ");
        bless = rd.readLine();

        System.out.println("Principal: Here, take this...\n");

        if (bless.equals("1")) {
            System.out.println(player.getName() + " feels stronger!\n");
            player.setPow(player.getPow() + 1);
            player.setDef(player.getDef() + 1);
            player.setSpd(player.getSpd() + 1);

            if (player.getPow() > player.getMaxpow()) {
                System.out.println(player.getName() + "'s ATK cannot be increased! \n");
                player.setPow(player.getMaxpow());
            }
            if (player.getDef() > player.getMaxdef()) {
                System.out.println(player.getName() + "'s DEF cannot be increased! \n");
                player.setDef(player.getMaxdef());
            }
            if (player.getPow() > player.getMaxpow()) {
                System.out.println(player.getName() + "'s SPD cannot be increased! \n");
                player.setPow(player.getMaxpow());
            }
            proceed = true;
        } else if (bless.equals("2")) {
            System.out.println(player.name + " feels sturdier!\n");
            player.setMaxhp(player.getMaxhp() + 2);
            player.setHp(player.getMaxhp());
            player.setMaxmana(player.getMaxmana() + 1);
            player.setMana(player.getMaxmana());
            player.setRec(player.getRec());
            proceed = true;
        } else if (bless.equals("3") && playerextra.mode.equals("Survival")) {
            if (!player.wpn.equals("Mop")) {
                System.out.println(player.name + " obtained a mop.\n");
                System.out.println(player.name + " felt a surge of strength!\n");
                player.setPow(player.getPow() + 1);
                player.setDef(player.getDef() + 1);
                player.setSpd(player.getSpd() + 1);
                player.wpn = "Mop";

            } else if (player.getWpn().equals("Mop") && !player.getWpn().equals("Vacuum Cleaner") && floor > 8) {
                System.out.println(player.name + " obtained the Clean-inator 9000.\n");
                player.setWpn("Vacuum Cleaner");
                System.out.println(player.name + " feels the strength of the vacuum, and feels a surge of strength!\n");
                player.setPow(player.getPow() + 2);
                player.setDef(player.getDef() + 2);
                player.setSpd(player.getSpd() + 2);

            } else if (player.armor.equals("School Uniform") && !player.armor.equals("PE Uniform") && floor > 5) {
                System.out.println(player.name + " obtained the school's PE uniform.\n");
                player.setArmor("PE Uniform");
            } else {
                System.out.println(player.name + " feels more powerful!\n");
                player.setPow(player.getPow() + 2);
            }
            proceed = true;
        } else {
            System.out.println("Principal: Wait, that answer does not seem right\n");
        }

        if (player.getPow() > player.getMaxpow()) {
            System.out.println(player.name + "'s ATK cannot be increased! \n");
            player.setPow(player.getMaxpow());
        }
        if (player.getDef() > player.getMaxdef()) {
            System.out.println(player.name + "'s DEF cannot be increased! \n");
            player.setDef(player.getMaxdef());
        }
        if (player.getSpd() > player.getMaxspd()) {
            System.out.println(player.name + "'s SPD cannot be increased! \n");
            player.setSpd(player.getMaxspd());
        }
    }

    checkStats(player, playerextra);
    gamePause();

    return player;
}

public static void ascii(String charName) {
    if (charName.equals("Trashman")) {
        System.out.println(
            "-------------------------------::..         :---------------------------------------------\n" +
            "---------------------------:.                ---------------------------------------------\n" +
            "--------------------------.              .   :--------------------------------------------\n" +
            "------------------------:                     :-------------------------------------------\n" +
            "------------------------.           .::        .------------------------------------------\n" +
            "-----------------------:        .:-=-:::.        .:-------------------------------------- \n" +
            "-----------------------.     ..:--:   ..            :-------------------------------------\n" +
            "----------------------        .           .=    .    .:------::---------------------------\n" +
            "-------------------:.:.    ...        -==++      .--.   ::....:---------------------------\n" +
            "---------------------:..:----.          .          .::    .-------------------------------\n" +
            "-----------------------=*=..                           ..   .:----------------------------\n" +
            "----------------------#@#*@#=.                   -++.     :. .:---------------------------\n" +
            "----------------------@% =@@@@*=.         .:=+%#-:*@.      .    :-------------------------\n" +
            "---------------------:*@@@@@@@@@%.        .@@@@@+::*@.             .:---------------------\n" +
            "------------------:.   :#@@@@%+:           .*@@@@@@*:                .:-------------------\n" +
            "----------------:.                             ...                      :-----------------\n" +
            "---------------:                                                 .      ------------------\n" +
            "--------------:                                                    ..    :----------------\n" +
            "--------------.                                                     .    :----------------\n" +
            "--------------:                ..:..                                :    :----------------\n" +
            "---------------.            ...     ..........                    :.     :----------------\n" +
            "----------------          ..                   .                ::       :----------------\n" +
            "----------------:                ..........                 .:-:..     :------------------\n" +
            "-----------------:.                                      .::-=--:     :-------------------\n" +
            "-------------------:.                                    ::=-:.    .:---------------------\n" +
            "-------------::..                                     ...:.        .::--------------------\n" +
            "-----------.                                                          ..:-----------------\n" +
            "---------:.                                                               :---------------\n" +
            "---------.                               :-:.                              .--------------\n" +
            "---------:                             .:---:                               .-------------\n" +
            "-----------..                       ..:------:.                             .-------------\n" +
            "--------------:::..:::::::----:::::------------::...                        .-------------\n" +
            "-----------------------------------------------------:..                   .--------------\n");
    } else if (charName.equals("Trash Soldier")) {
        System.out.println(
            "-------------------------------::..         :---------------------------------------------\n" +
            "---------------------------:.                ---------------------------------------------\n" +
            "--------------------------.              .   :-===========--------------------------------\n" +
            "------------------------:                     #@@@@@@@@@@@@@%%*+=-------------------------\n" +
            "------------------------.           .::        =@@@@@@@@@@@@@@@@@@%%%%%######-------------\n" +
            "-----------------------:        .:-=-:::.        :-===++*%@@@@@@@@@@@@@@@@@@@#------------\n" +
            "-----------------------.     ..:--:   ..            :--------==+*#@@@@@@@@@@#-------------\n" +
            "---------+#@@%#--------        .           .=    .    .:------::---+%@@@@@#+--------------\n" +
            "--------#@@@@@@@*---:.:.    ...        -==++      .--.   ::....:-----=+++-----------------\n" +
            "-------#@@@@@@@@@*----:..:----.          .   .=--   .::    .------------------------------\n" +
            "-------@@@@@@@@@@@#-----=*=..               .-.-:       ..   .:---------------------------\n" +
            "------*@@@@@@@@@@@@%=--#@#*@#=.                 . -++.     :.  .:-------------------------\n" +
            "------@@@@@@@@@@@@@@@+-@%  =@@@@*=.         .:=+%#-:*@.      .    :-----------------------\n" +
            "-----+@@@@@@@@@@@@@@@@-*@@@@@@@@@%.        .@@@@@+::*@.             .:--------------------\n" +
            "-----%@@@@@@@@@@@@@%+.  :#@@@@%+:           .*@@@@@@#:                .:------------------\n" +
            "-----%@@@@@@@@@@@%-                             ... +..                  :----------------\n" +
            "-----%@@@@@@@@@@#                                 ::-=.            .      ----------------\n" +
            "-----%@@@@@@@@@@                                   ::*:.            ..    :---------------\n" +
            "-----=#@@@@@@@@+                                     =               .    :---------------\n" +
            "---------=+*%@@*                ..:..               :+-              :    :---------------\n" +
            "------------=@@@=            ...     ..........      -             :.     :---------------\n" +
            "--------------=+=          ..                   .                ::       :---------------\n" +
            "-----------------:                ..........                  .:-:..     :----------------\n" +
            "------------------:.                                      .::-=--:     :------------------\n" +
            "--------------------:.                                    ::=-:.    .:--------------------\n" +
            "--------------::..                                     ...:.        .::-------------------\n" +
            "------------.                                                          ..:----------------\n" +
            "----------:.                                                               :--------------\n" +
            "----------.                               :-:.                              .-------------\n" +
            "----------:                             .:---:                               .------------\n" +
            "------------..                       ..:------:.                             .------------\n" +
            "---------------:::..:::::::----:::::------------::...                        .------------\n" +
            "------------------------------------------------------:..                   .-------------\n");
    } else if (charName.equals("Rat Mage")) {
        System.out.println(
            ".............................#+..........:+********+..........%:..........................\n" +
            "..........................:*#*..........=***********=.........-==:.......*-...............\n" +
            ".........................*#=..........:**************............=.......%#...............\n" +
            "........................-%*..........-***************+-..................-=...............\n" +
            "........................=+.........-********************:.................................\n" +
            "......................==--.........*********************+..-==++-...::....................\n" +
            "......................=+.....*++:=**********************###*+===#=...*....................\n" +
            "......................-#....+*:+*********************###+-::::::*+...*....................\n" +
            ".....................=#%....+#=*****************####%#+-:::::::-%-...=....................\n" +
            ".....................+%%:....#*************###%%%%%*-:::::::::+#=.........................\n" +
            "....................:+==....:=*********###%%%%**#%%%-::::-=+*#=...........................\n" +
            "....................*:....:*******+#*. +%%%%*  .-%%%*###**+-:..........*..................\n" +
            "....................-......:---:...*%%#%%%%%%***%%%%:.................::..................\n" +
            "...............-#....:........:::::+%%%*--=*%%%%%%%*::::::...:-...........................\n" +
            "...............................::::-%%####*#%%%%%%+::::......+=...........................\n" +
            "...............................:--+*#%%%%%%%%%%%%#*+:::......=#:.....:*:..................\n" +
            "...................:+.........:..=***%%%%%%%%%%#*****-........*:.....:%...................\n" +
            "..................:=#...........=****%%%%%%%%%%*******........#:.....:*+..................\n" +
            "..................:%%..........+*****%%%%%%%%%#*******+.......#=-:........................\n" +
            "..................:#=.........+***#*#%%%%%%%%%#********+........=##+......................\n" +
            "..................=#.........-**#*+*#%%%%%%%%%#*********:........-=#....:.................\n" +
            "..................+*.........+#%%:-*#%%%%%%%%%#**##%#***=..........*+:..=*:...............\n" +
            "..................#=.........*#+= **#%%%%%%%%%#*+#%%#****:...............==...............\n" +
            "..................%:.........*+:::=*#%%%%%%%%%+:::+%#****+...............+*...............\n" +
            "..................%-.........+*--+**#%%%%%%%%%*---********:..............:++..............\n" +
            ".................:%:.........=*.****#%%%%%%%%%#***********:...............:*..............\n" +
            ".................=%..........-******#%%%%%%%%%#***********=...............:#.*............\n" +
            ".................%=..........-*******%%%%%%%%%#************:::::::::.......:-%=...........\n" +
            "...............#*%:..........=*******#%%%%%%%%#************+:.......::.......=*...........\n" +
            "...............#*:.......::::=*******#%%%##%%%#************+-................%=...........\n" +
            "...............-%:.......:::::=*******=-:...:-*******-:=**-................=#+............\n" +
            "................-*+:...........:+*****+......-*****+-::.:..................+:.............\n" +
            ".................................-****=......+**+-........................................\n");
    } else if (charName.equals("Rat King")) {
        System.out.println(
            "++++++++++++++++++++++++++*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++++++++++++++*****+==++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++++++++++++=--+++=----===++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++++++++++=-----------------=+++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++++==+++=--------+------------+++=-::....-++++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++=.-:-==--------=*+---*=----+==-..:--===-.=+++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++-.==::=---*+=--****+****++**-.:-=======-.=+++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++=.-===*+=+*************##+=::-========-::++++++++++++++++++++++++++++++++++++++\n" +
            "++++++++++++:.-====*+********++==-:..--========--.:=++++++++++++++++++++++++++++++++++++++\n" +
            "+++++++++++++-.:--=:.:...............-=====--::.:=++++++++++=:..:-::-=++++++++++++++++++++\n" +
            "+++++++++++++++=-::.    .....   . .........::-=+++===+++++++.         =+++++++++++++++++++\n" +
            "+++++++++++++++++++...........   ....-+++++++++++-:::::-=+==#.        .+++=-=+++++++++++++\n" +
            "+++++++++++++======.....-:::.........===+++++++++:-===--:.  :##=:.   .+*=::-.+++++++++++++\n" +
            "++++++++++++++=====-....::-:........-=======+++++-:-=====-:.   -=+*#**=. -=-:+++++++++++++\n" +
            "++++++++=++++++++===-..............+++===+++++++++-:--=====:...:::.     .--:=+++++++++++++\n" +
            "+++++++++++++=====##*.............*###*===++++++++++=::::::+*%@@@@+*@#%#-:-+++++++++++++++\n" +
            "++++++++++++++++++##=...........-#####*+++++++++++++++++===-.:*##+..=++:++++++++++++++++++\n" +
            "++++++++++++++++=-##-..........=####=--=+++++++++++++++====-......--:..:====++++++++++++++\n" +
            "+++++++++++++++---*#..........-####+-----++++++++++++++++===-.....:+=..-===+++++++++++++++\n" +
            "++++++++++++++----+#:........-###+--------+++++++++++++++==: ........::  :==++++++++++++++\n" +
            "+++++++++++++=----=#-........=#*=---------=++++++========-    =#*=:-#@-  .=+++++++++++++++\n" +
            "++++++++++++=---:--=:.....:==+*-:::-------=+===*+=====++=.    .*@@#*@@:   -+++++++++++++++\n" +
            "++++++++++++=-::::-:......:***+-...:------=+==*++***####=     .:+@*=@+:    -++++++++++++++\n" +
            "+++++++++++++--===-:........:-+*+=---------*+*##########      .::=+-#:.     ++++++++++++++\n" +
            "+++++++++++++=-==--:.........:--===--------*###########*      .:::::-:.  .  =+++++++++++++\n" +
            "+++++++++++++=-----:.........:-------------+########*+*=    .--:::::::  :==.++++++++++++++\n" +
            "+++++++++++++=-----..........:-------------+####*+++*##-    .:-:::::::   :.-++++++++++++++\n" +
            "+++++++++++++------..........:------------+#======++**#:      .:::::::     :++++++++++++++\n" +
            "+++++++++++++=-----..........:----------+*#+==+*+======.       :::::::     :++++++++++++++\n" +
            "+++++++++++++#+----..........:------=+###=+++++++++++++-       :::::::     -++++++++++++++\n" +
            "+++++++++++++*#*+=-:......::..====+*###*-=++++++++++++++. ..   :::::::     =++++++++++++++\n" +
            "++++++++++++++**##*=--==++++++*##****++++++++++++++++++++++++: .==+==-  .-++++++++++++++++\n" +
            "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    } else if (charName.equals("Nurse Joy")) {
        System.out.println(
            "------------------------------------------------------------------------------------------\n" +
            "------------------------------------------------------------------------------------------\n" +
            "--------------------------------------------====------------------------------------------\n" +
            "-------------------------------------#@@@@@@@@@@@#+---------------------------------------\n" +
            "------------------------------------=@@@@@@@@@@@@@@+--------------------------------------\n" +
            "----------------------------------=+##############%*=-------------------------------------\n" +
            "---------------------------------=###################*------------------------------------\n" +
            "---------------------------------#####################=-----------------------------------\n" +
            "---------------------------------#####################=-----------------------------------\n" +
            "---------------------------------#####################+-----------------------------------\n" +
            "------------------------------=+####%%%%%%%%%%%%%%%##=*#+---------------------------------\n" +
            "----------------------------+*#*=+#%%%%%%%%%%%%%%%%#*--=*#+-------------------------------\n" +
            "--------------------------+##*=--=#%%%%%%%%%%%%%%%##+----*#*------------------------------\n" +
            "-------------------------*##=-----#%%%%%%%%%%%%%%%%*------+#*-----------------------------\n" +
            "------------------------+##=-------#%%%%%%%%%%%%%%#--------*#*----------------------------\n" +
            "------------------------##*---------*%%%%%%%%%%%%#=--------=##----------------------------\n" +
            "-----------------------+##=---------*+=+*%%%%%*=-*+=-------=##=---------------------------\n" +
            "-----------------------+##+--------=#+--=%%%%%*---+*#*+==-=*#*----------------------------\n" +
            "------------------------*##*+++++*###%%%%%%%%%%%%##@#######*+-----------------------------\n" +
            "--------------------------+*######%@@%%%%%%%%%%%%%@@@%%%%%+-------------------------------\n" +
            "---------------------------=%%%%%%@@@%%%%%%%%%%%%%@@@%%%%%%+------------------------------\n" +
            "---------------------------%%%%%%%@@@%%%%%%%%%%%%%@@@%%%%%%%=-----------------------------\n" +
            "--------------------------#%%%%%%%@@@%%%%%%%%%%%%%@@%%%%%%%%+-----------------------------\n" +
            "--------------------------#%%%%%%%@@@@@@@@@@@@@@@@@@%%%%%%%+------------------------------\n" +
            "---------------------------#%%%%%%@@@@@@@@@@@@@@@@@@%%%%%%*-------------------------------\n" +
            "----------------------------#%%%%%%@@@@@@@@@@@@@@@@%%%%%%#--------------------------------\n" +
            "-----------------------------#%%%%%%@@@@@@@@@@@@@@%%%%%%%+--------------------------------\n" +
            "------------------------------@%%%%%%@@@@@@@@@@@@%%%%%@@@@--------------------------------\n" +
            "-----------------------------=@@%%%%%%@@@@@@@@@@%%%%%%@@@@--------------------------------\n" +
            "-----------------------------=@@@%%%%%%@@@@@@@@%%%%%%@@@@%--------------------------------\n" +
            "-----------------------------+@@@@%%%%%%@@@@@@%%%%%@@@@@@%--------------------------------\n" +
            "-----------------------------%@@@@@%%%%%%@@@@%%%%%@@@@@@@@--------------------------------\n" +
            "----------------------------=@@@@@@@%%%%%%@@%%%%%@@@@@@@@@=-------------------------------\n");
    } else if (charName.equals("Principal")) {
        System.out.println(
            "------------------------------------------------------------------------------------------\n" +
            "------------------------------------------------------------------------------------------\n" +
            "------------------------------------------------------------------------------------------\n" +
            "--------------------------------=+++*****++==---------------------------------------------\n" +
            "----------------------------=+*****************=------------------------------------------\n" +
            "---------------------------***********+++===+***+-----------------------------------------\n" +
            "---------------------------******-.            =*=----------------------------------------\n" +
            "--------------------------=*****:               +=----------------------------------------\n" +
            "--------------------------=****=                :=----------------------------------------\n" +
            "---------------------------+**-                 .=----------------------------------------\n" +
            "---------------------------:=-                   -----------------------------------------\n" +
            "---------------------------:-:                 =------------------------------------------\n" +
            "---------------------------+*-    .:-=====-:: :*------------------------------------------\n" +
            "----------------------------**:   +*=-----=+*--**-----------------------------------------\n" +
            "----------------------------***=:.*+       .****+=----------------------------------------\n" +
            "-------------------------====+*****=..=*+:-+***+=====.::----------------------------------\n" +
            "--------------------:..==========************=======-    .:-------------------------------\n" +
            "-------------:::::.    .======== .+********=.-======.     : .-----------------------------\n" +
            "------------   . ..-:   .=======: .=****+. ======:     :. .-=-----------------------------\n" +
            "-----------:        .=. .=======    =++=: :======      =-*%@@@@@@#+-----------------------\n" +
            "-----------          :=   :======:   ====: ======. .+#@@@@@@@@@@@@@@#---------------------\n" +
            "----------:           =:   :======. ====- -=====. -#@@###*#@@@@@@@@@@@@+------------------\n" +
            "----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------\n" +
            "---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------\n" +
            "---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------\n" +
            "---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------\n" +
            "--------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------\n" +
            "---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------\n" +
            "---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------\n" +
            "--------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------\n" +
            "--------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------\n" +
            "--------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+. :@@@@@@@@@@@@@@*--------------------\n" +
            "--------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------\n" +
            "------------------------------------------------------------------------------------------\n");
    }  else if (charName.equals("Merchant")) {
        System.out.println(                                                                                                                                              
			"-----------------------------------------------:---.--------------------------------------\n" +                                     
			"-------------------------------------------=**######+.------------------------------------\n" +                                   
			"----------------------------------------=##############-----------------------------------\n" +                                  
			"-------------------------------------.+%#################=--------------------------------\n" +                                
			"------------------------------------=################*++*##:------------------------------\n" +                              
			"-----------------------------------*##############*+++=+++*#=-----------------------------\n" +                             
			"----------------------------------+#############*===-==++=%%%:----------------------------\n" +                            
			"---------------------------------=##########%%=+-::::=::+-%%#+----------------------------\n" +                            
			"---------------------------------##########%*+**##=-==::+=+%##----------------------------\n" +                            
			"----------------.====----::....:+%####%###%+-+++*+*#***####%##=--------------==-:---------\n" +         
			"---------------:**+====+*#*#++++#####%%##%@=-=+#**+++++##+%%%##::---------.*+===+=--------\n" +        
			"-----:=+.-----:##**====+*###+=+=####%%%%%%%##**+=+++++++**%%%%#++----------*==++++--------\n" +        
			"---:*+*##-----##***====+*###++++####%%%%%#*++===-=+++++*++%%%%#*=+--------.*+=+=*=--------\n" +        
			"---#**%**+---=#****+==++*##*+++++%#%%%%%%#+*+++++++===+*+*%%%%#+=+---------.*++-+---------\n" +         
			"-:**##*****.-*#*#**+==+=####*+++*#%%%%%%%##***+=++++++=+*%%%%%#===------::::+=+:=.--------\n" +        
			".++##******+.###%#*+=++*%%%%######%%%%%%%%%*##+=+++++++*%%%%%*===---.::==+*+%%#-=.--------\n" +        
			":*%#********=+####***##%%##%%####%%%%%%%%%%**###*+++++*%%%%#*+==+---=+##%#%##%###---------\n" +         
			"-+%###******#=##%%%%%##%%###%%%%%%%%%%%%@%%%######*+*%%%%%%#*+==----=#####%%####*---------\n" +         
			"--.+####*****#=%%######%%###%%%%%%%%%%%%%%%@@%%#*#%%%%%%%%%%#*+=----:+#%##%%####+---------\n" +         
			"----.+###****%%########%%##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%###%#+.----##########----------\n" +         
			"------.=##**%########%#%%##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####%%#%+:.:%#########----------\n" +          
			"--------.=#%#########%#%%##%%%%%%%%%%%%%%*@%#%%%%%%%%%%%%#####%#%###::##%%%%%##-----------\n" +          
			"-----------########%#%%%###%%%%%%%%%%%%%%%%%%%%%%%%############%%#%#*.+%%%%%%%#.----------\n" +          
			"----------*###########%%###%%###%%%%%%%%%%%%%%#################%%#%##-*%%###%%=-----------\n" +           
			"---------=############%###%%%###%%%%###%%%%%%%#################%##%##%*=+=====------------\n" +           
			"--------:#############%%##%%###########%%#%####################%##%#%%%%#*****%%+:--------\n" +        
			"-------.*############%%%##%%###########%@%#####################%%#%#%############*--------\n" +        
			"-------##############%%###%############%%######################%%#%%%############:--------\n" +        
			"-------%##%##########%%###%###########%%%#####################%%%#%%%%##########:---------\n" +         
			"------##%%%%########%%%##%%##########%%%%#####################%%%#%%%%%########*.---------\n" +         
			"------#%%%%%#######%%%###%%########%%%%%%###################%%%%%#%%%%%%%#######----------\n"); 
    } else if (charName.equals("Vacuum")) {
        System.out.println(
            "..........................................................................................\n" +
            "..........................................................................................\n" +
            ".............................................              ...............................\n" +
            "..........................................   .--.                                .........\n" +
            ".......................................     :*===:                    ....................\n" +
            "......................................      *@..==.                      .................\n" +
            "....................................        %@ -==                        ...............\n" +
            "...................................        .@% .==.                        ..............\n" +
            "..................................         =@*   ==-......                   .............\n" +
            ".................................          %@= .=======--===-:.              ............\n" +
            ".................................         .@@: ========.::======-.            ...........\n" +
            "................................          +@@ -===================-            ..........\n" +
            "..............................            @@# -=========:---========-            .........\n" +
            ".............................            -@@*============:-==========.            ........\n" +
            "...........................              *@@+===========-:-===========             .......\n" +
            ".........................               .@@@=============:============-            .......\n" +
            ".......................               .-*@@%============--:============.            ......\n" +
            "......................              .===%@@*============--=:===========-            ......\n" +
            "....................              .=====@@@+============--:-============             .....\n" +
            "...................              -=====*@@@==============.-=============.            .....\n" +
            "..................              -======#@@#=============--:=============:            .....\n" +
            "................               -=======@@@*==============-:-============-             ....\n" +
            "..............                -=======+@@@================:=============-             ....\n" +
            "............                 .========#@@%===============--:-===========-             ....\n" +
            "..........                   -========@@@*===============.::-===========-             ....\n" +
            "........                     ========*@@@================-:-============-             ....\n" +
            ".......                      ========%@@#================ ..============-            .....\n" +
            ".......                .=-=+*#%%@@@@@@@@@@@@@@@%%%%#**++=-=-============-            .....\n" +
            "......             .=*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+==============.           ......\n" +
            ".......           -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.    -=========:         ........\n" +
            "........          %@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.      -========         .........\n" +
            ".........              .........                                .:----:        ...........\n" +
            "...........                                                                  .............\n" +
            "");
    } else if (charName.equals("Mop")) {
        System.out.println(
            "----------------==============------------------------------------------------------------\n" +
            "---------------=================----------------------------------------------------------\n" +
            "--------------====================--------------------------------------------------------\n" +
            "--------------=========+===========-------------------------------------------------------\n" +
            "--------------========#%#============-----------------------------------------------------\n" +
            "---------------========%%%+===========----------------------------------------------------\n" +
            "---------------=========%%%*===========---------------------------------------------------\n" +
            "----------------=========%%%#===========--------------------------------------------------\n" +
            "-----------------=========%%%%+==========-------------------------------------------------\n" +
            "------------------=========#%%%+==========------------------------------------------------\n" +
            "-------------------=========#%%%*=========------------------------------------------------\n" +
            "--------------------=========#%%%#=========-----------------------------------------------\n" +
            "---------------------=========*%%%#=========----------------------------------------------\n" +
            "----------------------=========*%%%%+========---------------------------------------------\n" +
            "-----------------------=========+%%%%+==========------------------------------------------\n" +
            "-----------------------==========+%%%%*=============--------------------------------------\n" +
            "------------------------==========+%%%%*=================---------------------------------\n" +
            "-------------------------===========%%%%#===================------------------------------\n" +
            "--------------------------===========#%%%%====================----------------------------\n" +
            "--------------------------============#%%%%+====+**=============--------------------------\n" +
            "---------------------------============*%%%%**#%%@@##*============------------------------\n" +
            "---------------------------=============*%%%%@@@@@@@@@@@@%%#=======-----------------------\n" +
            "---------------------------==========+*#%@@@@@@@@@@@@@@@@@@@@#======----------------------\n" +
            "---------------------------=========#%@@@@@@@@@@@@@@@@@@@@@@@@%*=====---------------------\n" +
            "---------------------------========+%@@@@@@@@@@@@@@@@@@@@@@@+*%@@@*==---------------------\n" +
            "---------------------------========#@@@@@@@@@@@@@@@@@@@@@@@@#+==*#+===--------------------\n" +
            "---------------------------========%@@#@@@@@@@@@@@@@@@@@@@@@@@#+======--------------------\n" +
            "---------------------------=======+@@**@@@@@@@@@@@@@@@@@@@@%#%%%+====---------------------\n" +
            "----------------------------======#@#==%@@@@@@@@@@@@@@@@@@@#=========---------------------\n" +
            "----------------------------=====+#@@==%@@#@@@@@@@@@@@@@#*#+========----------------------\n" +
            "-----------------------------======*+==##==#@@@@@@%%@@@#===========-----------------------\n" +
            "------------------------------==============####*+==**+===========------------------------\n" +
            "-------------------------------=================================--------------------------");
    } else {
        System.out.println("Enemy not found.");
    }  
}

public static Character afterBattle(Character player, Extra playerSkills, Character enemy) throws IOException {
    int expGain = 0; int moneyGain = 0;
    int levelDifference = enemy.getLvl() - player.getLvl();

    if (levelDifference >= 0) {
        expGain += (levelDifference * 25 + 50); // Normal calculation for higher or equal level
    } else if (levelDifference < -1 && levelDifference > -2 && playerSkills.getDifficulty().equals("hard")) {
        expGain += (levelDifference * 10 + 20); // Normal calculation for higher or equal level
    } else if (levelDifference < -1 && !playerSkills.getDifficulty().equals("hard")) {
        expGain += (levelDifference * 10 + 20); // Normal calculation for higher or equal level
    } else {
        // Additional experience gain for lower-level player
        expGain += (levelDifference * 10 + 50);
    }

    moneyGain = enemy.getLvl() * 10 + player.getLvl() * levelDifference + 1;

    player.setExp(player.getExp() + expGain);
    if (playerSkills.getMode().equals("Game")) {
        playerSkills.setMoney(playerSkills.getMoney() + moneyGain);
        System.out.println(player.getName() + " gained P" + moneyGain + "!");
    }
    System.out.println(player.getName() + " gained " + expGain + " EXP!\n\n");
    

    while (player.getExp() >= 100) {
        gamePause();
        player.setLvl(player.getLvl() + 1);
        player.setExp(player.getExp() - 100);
        clearConsole();
        System.out.println(player.getName() + " leveled up!\n");
        player.setHp(player.getHp() + 5);
        player.setMaxhp(player.getMaxhp() + 5);
        player.setPow(player.getPow() + 1);
        player.setDef(player.getDef() + 1);
        player.setSpd(player.getSpd() + 1);
        player.setRec(player.getRec() + player.getLvl());
        player.setMaxmana(player.getMaxmana() + 1);
        player.setMana(player.getMaxmana());

        if (player.getPow() > player.getMaxpow()) {
            System.out.println(player.getName() + "'s ATK cannot be increased! \n");
            player.setPow(player.getMaxpow());
        }
        if (player.getDef() > player.getMaxdef()) {
            System.out.println(player.getName() + "'s DEF cannot be increased! \n");
            player.setDef(player.getMaxdef());
        }
        if (player.getSpd() > player.getMaxspd()) {
            System.out.println(player.getName() + "'s SPD cannot be increased! \n");
            player.setSpd(player.getMaxspd());
        }

        if (playerSkills.getMode().equals("Survival")) {
            player.setHp(player.getMaxhp());
        }

        String[] skills = playerSkills.getSkills();

        if (!skills[0].equals("Reversal") && player.getLvl() >= 2) {
            System.out.println("Acquired the skill \"Reversal\"\n");
            skills[0] = "Reversal";
        } else if (!skills[1].equals("Piercing Thrust") && player.getLvl() >= 5) {
            System.out.println("Acquired the skill \"Piercing Thrust\"\n");
            skills[1] = "Piercing Thrust";
        } else if (!skills[2].equals("Heavy Impact") && player.getLvl() >= 8) {
            System.out.println("Acquired the skill \"Heavy Impact\"\n");
            skills[2] = "Heavy Impact";
        }

        playerSkills.setSkills(skills);

        checkStats(player, playerSkills);
    }

    gamePause();
    return player;
}

public static Character mainhub(Character player, Extra playerextra) throws IOException{
    boolean explore = true;
    while (explore) {
        clearConsole();
        String choice;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Johnny is at the school entrance, what do you want him to do?\n");
        System.out.println("1. Head to the classroom (Recommended level - 1)\n2. Head to the field (Recommended level - 3)\n3. Head to the bathroom (Recommended level - 5)\n4. Head to the clinic (Heal passes left: " + playerextra.hpass + ")\n5. Head to the bookstore (Money: " + playerextra.money + ")\n6. Item Menu\n");
        System.out.print(player.getName() + ": ");
        choice = rd.readLine();

        if (choice.equals("1")) {
            System.out.println("Heading to the classroom...\n");
            gamePause();
            maincroom(player, playerextra);
        } else if (choice.equals("2")) {
            System.out.println("Heading to the field...\n");
            gamePause();
            mainfield(player, playerextra);
        } else if (choice.equals("3")) {
            System.out.println("Heading to the bathroom...\n");
            gamePause();
            mainbroom(player, playerextra);
        } else if (choice.equals("4")) {
            clearConsole();
            ascii("Nurse Joy");
            System.out.println("2619th Nurse Joy: Welcome to our school's clinic!\n");
            System.out.println("2619th Nurse Joy: We heal students back to perfect health in exchange for a heal pass!\n");
            gamePause();
            System.out.println("2619th Nurse Joy: Shall we heal you? (Y/N) (Heal passes left: " + playerextra.hpass + ") \n");
            System.out.print(player.name + ": ");
            choice = rd.readLine();

            if ((choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) && playerextra.hpass > 0) {
                System.out.println("You went to get patched up...\n");
                player.hp = player.maxhp;
                player.mana = player.maxmana;
                playerextra.hpass--;
                System.out.println("2619th Nurse Joy: Thank you! You are now fighting fit!\n");
                System.out.println("2619th Nurse Joy: We hope to see you again!\n");
                gamePause();
            } else if (playerextra.hpass <= 0) {
                System.out.println("2619th Nurse Joy: It seems you do not have a heal pass...\n");
                System.out.println("2619th Nurse Joy: Come back when you have one!\n");
                System.out.println("2619th Nurse Joy: We hope to see you again!\n");
                gamePause();
            } else {
                System.out.println("Strong men don't need rest anyway...\n");
                System.out.println("2619th Nurse Joy: We hope to see you again!\n");
                gamePause();
            }

            clearConsole();
        } else if (choice.equals("5")) {
            System.out.println("Heading to the bookstore...\n");
            gamePause();
            bookstore(player, playerextra);
        } else if (choice.equals("6")) {
            itemMenu(player, playerextra);
            gamePause();
        } else {
            System.out.println("Incorrect input, try again...\n");
            gamePause();
        }
    }

    return player;
}

public static Character maincroom(Character player, Extra playerextra) throws IOException {
    boolean step1 = true, step2 = true, step3 = true, explore = true; 
    String choice;
    int step = 0;

    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    while (explore) {
        clearConsole();
        System.out.println("" +
        "------------------------------------------------------------------------------------------\n" +
        "---------------------------------------------------------------------------------------:::\n" +
        "-------:::------------------------------------------------------::::::::::::..............\n" +
        "-----.     :------------------------------::::::::::::....................................\n" +
        "=====---=-:---------------:::::...........................................................\n" +
        "================---------:................................................................\n" +
        "================---------:................................................................\n" +
        "================---------:................................................................\n" +
        "================---------:................................................................\n" +
        "=================--------:................................................................\n" +
        "================---------:................................................................\n" +
        "=================--------:................................................................\n" +
        "=================- .-----:................................................................\n" +
        "================--. :----:................................................................\n" +
        "============.-===-: .----:................................................................\n" +
        "==========+*:=%%%=:  ----:................................................................\n" +
        "    .*#%%@@%#*+=---  :------:::::::.......................................................\n" +
        ":=+#%%#*+=--------==:=+==-------------.  .::::::..........................................\n" +
        "#*+=---------+*#%@##+@@@@@@%#---------. .-------------::::::..............................\n" +
        "-------==-..  .-=%@@@@@@@@@@+--------: .-------------------------.        ................\n" +
        "-=+*#%@@@@@@#*#*  +@@@@@@@@@+---------: :-----------------------:         ----:.  ..:.....\n" +
        "@@@@@@@@@@@@@@@@@- *@@@@@@@@+---------: :-----------------------.        -----      ------\n" +
        "@@@@@@@@@@@@@@@@@*.%@@@@@@@@+---------: -----------==-...======--------------:      ------\n" +
        "@@@@@@@@@@@@@@@@@=-@@@@@@@@@+---------. ---------====::-======-------------==      .------\n" +
        "@@@@@@@@@@@@@@@@@#-@@@@@@@@@+---------. -------=========--====------------====-----====---\n" +
        "@@@@@@@@@@@@@@@@@@.%@@@@@@@@+----------:--------=++=========+------------==============---\n" +
        "@@@@@@@@@@@@@@@@@@.%@@@@@%*=--::-----------------##--#=-#*=+#-----------=============+----\n" +
        "@@@@@@@@@@@@@@@@@%.@@@@#+------:-:---------------##--%=-@#-+*-----------==+==========+----\n" +
        "@@@@@@@@@@@@@@@@@%%@%*=---------:.-----=--=======##--*--@#-+*------------=@+#=---=+*+=----\n" +
        "@@@@@@@@@@@@@@@@@@#+-----------:::---===---:-=======+---@#-++------------=@+#=----*@%-----\n" +
        "@@@@@@@@@@@@@@@%*=----:..:--------=================+=---@#----------======-:++----*@%-----\n" +
        "@@@@@@@@@@@@%#+----:::..:--------============-.-==+=---=@#---------======:  :=====+%%-----\n" +
        "@@@@@@@@@@%+-------:..:----------==++=========-====----=@*--------========   -=====#*-----\n" +
        "");
        System.out.println("You are at the dirtiest classroom you've ever seen, it reeks here, what do you want to do?");
        System.out.println("1. Go forward\n2. Go backward\n3. Go back to the main entrance\n4. Item Menu\n");
        System.out.print(player.name + ": ");
        choice = rd.readLine();

        if (choice.equals("1")) {
            System.out.println(player.name + " went forward.\n");
            step++;
        } else if (choice.equals("2")) {
            System.out.println(player.name + " player went backward.\n");
            step--;
        } else if (choice.equals("3")) {
            System.out.println(player.name + " went back to the entrance.\n");
            mainhub(player, playerextra);
        } else if (choice.equals("4")) {
            itemMenu(player, playerextra);
        } else {
            System.out.println("Incorrect input, try again...\n");
        }

        if (step == 1 && step1) {
            clearConsole();
            System.out.println("" +
            "------------------------------------------------------------------------------------------\n" +
            "---------------------------------------------------------------------------------------:::\n" +
            "-------:::------------------------------------------------------::::::::::::..............\n" +
            "-----.     :------------------------------::::::::::::....................................\n" +
            "=====---=-:---------------:::::...........................................................\n" +
            "================---------:................................................................\n" +
            "================---------:................................................................\n" +
            "================---------:................................................................\n" +
            "================---------:................................................................\n" +
            "=================--------:................................................................\n" +
            "================---------:................................................................\n" +
            "=================--------:................................................................\n" +
            "=================- .-----:................................................................\n" +
            "================--. :----:................................................................\n" +
            "============.-===-: .----:................................................................\n" +
            "==========+*:=%%%=:  ----:................................................................\n" +
            "    .*#%%@@%#*+=---  :------:::::::.......................................................\n" +
            ":=+#%%#*+=--------==:=+==-------------.  .::::::..........................................\n" +
            "#*+=---------+*#%@##+@@@@@@%#---------. .-------------::::::..............................\n" +
            "-------==-..  .-=%@@@@@@@@@@+--------: .-------------------------.        ................\n" +
            "-=+*#%@@@@@@#*#*  +@@@@@@@@@+---------: :-----------------------:         ----:.  ..:.....\n" +
            "@@@@@@@@@@@@@@@@@- *@@@@@@@@+---------: :-----------------------.        -----      ------\n" +
            "@@@@@@@@@@@@@@@@@*.%@@@@@@@@+---------: -----------==-...======--------------:      ------\n" +
            "@@@@@@@@@@@@@@@@@=-@@@@@@@@@+---------. ---------====::-======-------------==      .------\n" +
            "@@@@@@@@@@@@@@@@@#-@@@@@@@@@+---------. -------=========--====------------====-----====---\n" +
            "@@@@@@@@@@@@@@@@@@.%@@@@@@@@+----------:--------=++=========+------------==============---\n" +
            "@@@@@@@@@@@@@@@@@@.%@@@@@%*=--::-----------------##--#=-#*=+#-----------=============+----\n" +
            "@@@@@@@@@@@@@@@@@%.@@@@#+------:-:---------------##--%=-@#-+*-----------==+==========+----\n" +
            "@@@@@@@@@@@@@@@@@%%@%*=---------:.-----=--=======##--*--@#-+*------------=@+#=---=+*+=----\n" +
            "@@@@@@@@@@@@@@@@@@#+-----------:::---===---:-=======+---@#-++------------=@+#=----*@%-----\n" +
            "@@@@@@@@@@@@@@@%*=----:..:--------=================+=---@#----------======-:++----*@%-----\n" +
            "@@@@@@@@@@@@%#+----:::..:--------============-.-==+=---=@#---------======:  :=====+%%-----\n" +
            "@@@@@@@@@@%+-------:..:----------==++=========-====----=@*--------========   -=====#*-----\n" +
            "");
            System.out.println("You find the classroom to be filled with dirt and grime.");
            System.out.println("A moving piece of trash attacks you!");
            gamePause();
            Character trashman = new Character("Trashman", "Sword", "N/A", 1, 30, 30, 2, 0, 2, 5, 0, 0, 0, 0, 0, 0);
            battleSimulation(player, playerextra, trashman); 
            player = afterBattle(player, playerextra, trashman); 
            player = incentives(player, trashman); 
            step1 = false;
        }

        else if (step == 2 && step2) {
            clearConsole();
            System.out.println("" +
            "==========================================================================================\n" +
            "=================================================================================+++***===\n" +
            "===================================================================+++***##%%%@@@@@@@@@===\n" +
            "=====================================================+++***##%%%@@@@@@@@@@@@@@@@@@@@@@@===\n" +
            "=======================================+++**###%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
            "====================================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
            "------==============================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
            "....    ....:::::::::::...:-========*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%#+=.:=\n" +
            "...    ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@#%%%%%%%*-::-=+*#######=    #\n" +
            "..     ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@########.       .######*-::+#\n" +
            ".     ...............    ..-========*@@@@@@@@@@@@@@@@@@@@@@@@########=       *############\n" +
            "     ...............    ...:=========++++++*-   =************#########      =#############\n" +
            "     ................    ...-================:   -============#########-     *#############\n" +
            "    ...       .....    ....-================-  :=============#########+    +##############\n" +
            "   .....     .....    .....-=================. .=============##########   .###############\n" +
            "  ................    .....-=================-:-=============##########   -###############\n" +
            "  ...............    ..... .=================================##########=.:*###############\n" +
            " ...............    .::::   :.::==++=========================#############################\n" +
            "....  .........  .-=+++=:    .    :++========================#############################\n" +
            "...   ...:::-=-   ::::. .==++++=  ===========================#############################\n" +
            "...   -==+=-.         :++++*****--===========================#############################\n" +
            "-==   :..         ..  =*********-:===========================#############################\n" +
            "-.         :--=+++++. =**+***++=-:===========================######################  #####\n" +
            ".     .-=++++++*****- -++++=====--===========================##########+-:=#######-. =####\n" +
            "-.    ++++++*********:-====---==--===========================#######*-.  :*#######  -*####\n" +
            "+=   :++****++******+--=--::::::--:----======================######*  .=##########- =#####\n" +
            "+:   =*****+**+++===--::::::::.      :::::-------============#####+::-:..:*###*.+##+ +####\n" +
            "**=  -****+======--::..::::..         .::::::::::::-------===###+. :--=#= +###= -*#* =####\n" +
            "**- .****====---:::::. :::            ::::::::::::::::::::::-###++*##*=  --::##= :. +#####\n" +
            "***+**++==--:::::::::  ::.           .::::::::::::::::::::::-######+.  ..  .+#+  :. ######\n" +
            "+*+:.==--::::::.                    .:::::::::::::::::::::::-#######+*#*..+###+.   -######\n" +
            "===  ::::::::                   ..::::::::::::::::::::::::::-###############-.  .: *######\n" +
            "--:   :::::.                 .::::::::::::::::::::::::::::::-###########=-:. .:::. =######\n" +
            "");
            System.out.println("You inch closer and see an item by the corner.");
            System.out.println("A Rat mage emerges from the vents!");
            gamePause();
            
            Character ratmage = new Character("Rat Mage", "Reekburst", "N/A", 2, 30, 30, 1, 1, 5, 5, 1, 1, 0, 0, 0, 0);
            battleSimulation(player, playerextra, ratmage);
            player = afterBattle(player, playerextra, ratmage);
            player = incentives(player, ratmage);
            step1 = false;
        }
        
        else if (step == 3 && step3 == true && !player.getWpn().equals("Mop")) {
            clearConsole();
            if (!player.wpn.equals("Mop")) {
                ascii("Mop");
                System.out.println("After inspecting further... you found a mop!\n");
            } else if (!player.wpn.equals("Mop")) {
                ascii("Mop");
                System.out.println(player.name + ": The mop is still lying there...");
            }
        
            System.out.println("Would you like it equipped? (Y/N)\n");
            System.out.print(player.name + ": ");
            choice = rd.readLine();
        
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                System.out.println(player.name + ": Hell yeah!\n");
                System.out.println(player.name + " obtained a mop!\n");
                player.setWpn("Mop");
                step3 = false;
            } else {
                System.out.println("Strong men don't need a mop to clean anyway...\n");
            }
        }

        else if (step > 3 || step < 0) {
            System.out.println(player.name + ": Can't go further...\n");
            if (step > 3) {
                step--;
            } else if (step < 0) {
                System.out.println(player.name + " went back to the main entrance\n");
                mainhub(player, playerextra);
            }
        } else if (choice.equals("4")) {
        } else {
            System.out.println(player.name + ": This place is empty...\n");
        }

        gamePause();
        clearConsole();
    }

    return player;
}

    public static Character mainbroom(Character player, Extra playerextra) throws IOException {
        boolean step1 = true, step2 = true, step3 = true, step4 = true, explore = true;
        String choice;
        int step = 0, boredom = 2;

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (explore) {
            clearConsole();
            System.out.println("" +
            ".......................:###++++++++++**++++++++++++=...........................::::.::....\n" +
            ".......................:###+++++++++*****++++++++++=.....................::....::::::::...\n" +
            ".......................:###++++++++****##**++++++++=...................:::::::::---=:::...\n" +
            ".......................:###++++++*#****###**+++++++=...............:.:::-:---::-------:...\n" +
            ".......................:###+++++###********##++++++=............::::----=-+===--=-===-::..\n" +
            ".......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:\n" +
            ".......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:\n" +
            ".......................:###+++*###########*****++++=..............:::--=---=--=--=====-::.\n" +
            ".......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:\n" +
            ".......................:###+++###########***+++++++=..............::::::::::::::::::---:..\n" +
            ".......................:###++*#++*####*#*****++++++=....................::.::::::::--:::..\n" +
            ".......................:###++##**#########***++++++=...............:.::::..:::::::::--:-:.\n" +
            ".......................:###++***###########*#*+++++=..............::+=--::..::.::::--::::.\n" +
            ".......................:###+++**#############***+++=............::-@@@#-:::.......:::::::.\n" +
            ".......................:###++++++*##########***++++=.............:=@@@#--::........:..::..\n" +
            ".......................:###++++++*##****#*##**+++++=.............#@@@@@@-.::..............\n" +
            ".......................:###++++++*+++++*###*+++++++=.............%@@@@@@=:................\n" +
            ".......................:###++++++++++++++++++++++++=.............#@@@@@@-.................\n" +
            ".......................:###++++++++++++++++++++++++=..............=@@@%:..................\n" +
            ".......................:###++++++++++++++++++++++++=..............-@%@%...................\n" +
            "::..-::.:::............:###++++++++++++*+**++++++++=..............-@*@@:..................\n" +
            "-::-:----:-::..........:###+++++++++++**##*++++++++=..............-@+#@:..................\n" +
            "-=++=+*===--:..........:###++++++++++***#**++++++++=......................................\n" +
            "+*+++++++=-::..........:###+++++++**#*****+++++++++=......................................\n" +
            "++=+==--+--:...........:###+++++++*#*****++++++++++=......................................\n" +
            "=+-+=+==-:::...........:###++++++++++++*+++++++++++=......................................\n" +
            "+****+*+=--:::.........:###++++++++++++++++++++++++=.....::..:.::...........:-............\n" +
            "=**+****+=-:::.........:###+++++++*++++++++++++++++=.....:-:::-::........::----:::........\n" +
            "=-=*****+==--:::::-....:###**#***#++++*++++++++++++=.....:-=---:.......::=++=*+=-:........\n" +
            "=--*++=+====++==-:.....:###*#####*+++++++++++++++++=......:=-==:.:::...--++++====::.......\n" +
            "=--=-=-=:--=++==--:....:########**++++**+++++++++++=......::::::::::::--=+=---:::.........\n" +
            "+===---=----=*---::....:###*###*++++++*++++++++++++=.......:.:...::-=--=-==-::............\n" +
            "++++==-=-=----::-::....:###+***+++++++*++++++++++++=...........:-:=-==-==--::.............\n" +
            "==--:::=::--:::........:###+++++++++++*++++++++++++=...........::.:-:::-:--:..............\n" +
            "::...:.::..:...........:###+++++++++++*++++++++++++=..............-:..:::..:..............\n" +
            "");
            System.out.println("You are at the not-so-comfort room, graffiti is plastered everywhere, what do you want to do?");
            System.out.println("1. Go forward\n2. Go backward\n3. Go back to the main entrance\n4. Item Menu\n");
            System.out.print(player.name + ": ");
            choice = rd.readLine();

            if (choice.equals("1")) {
                System.out.println(player.name + " went forward.\n");
                step++;
            } else if (choice.equals("2")) {
                System.out.println(player.name + " player went backward.\n");
                step--;
            } else if (choice.equals("3")) {
                System.out.println(player.name + " went back to the entrance.\n");
                mainhub(player, playerextra);
            } else if (choice.equals("4")) {
                itemMenu(player, playerextra);
            } else {
                System.out.println("Incorrect input, try again...\n");
            }

            if (step == 1 && step1) {
                clearConsole();
                System.out.println("" +
                ".......................:###++++++++++**++++++++++++=...........................::::.::....\n" +
                ".......................:###+++++++++*****++++++++++=.....................::....::::::::...\n" +
                ".......................:###++++++++****##**++++++++=...................:::::::::---=:::...\n" +
                ".......................:###++++++*#****###**+++++++=...............:.:::-:---::-------:...\n" +
                ".......................:###+++++###********##++++++=............::::----=-+===--=-===-::..\n" +
                ".......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:\n" +
                ".......................:###+++*###########*****++++=..............:::--=---=--=--=====-::.\n" +
                ".......................:###+++###########***+++++++=..............::::::::::::::::::---:..\n" +
                ".......................:###++*#++*####*#*****++++++=....................::.::::::::--:::..\n" +
                ".......................:###++##**#########***++++++=...............:.::::..:::::::::--:-:.\n" +
                ".......................:###++***###########*#*+++++=..............::+=--::..::.::::--::::.\n" +
                ".......................:###+++**#############***+++=............::-@@@#-:::.......:::::::.\n" +
                ".......................:###++++++*##########***++++=.............:=@@@#--::........:..::..\n" +
                ".......................:###++++++*##****#*##**+++++=.............#@@@@@@-.::..............\n" +
                ".......................:###++++++*+++++*###*+++++++=.............%@@@@@@=:................\n" +
                ".......................:###++++++++++++++++++++++++=.............#@@@@@@-.................\n" +
                ".......................:###++++++++++++++++++++++++=..............=@@@%:..................\n" +
                ".......................:###++++++++++++++++++++++++=..............-@%@%...................\n" +
                "::..-::.:::............:###++++++++++++*+**++++++++=..............-@*@@:..................\n" +
                "-::-:----:-::..........:###+++++++++++**##*++++++++=..............-@+#@:..................\n" +
                "-=++=+*===--:..........:###++++++++++***#**++++++++=......................................\n" +
                "+*+++++++=-::..........:###+++++++**#*****+++++++++=......................................\n" +
                "++=+==--+--:...........:###+++++++*#*****++++++++++=......................................\n" +
                "=+-+=+==-:::...........:###++++++++++++*+++++++++++=......................................\n" +
                "+****+*+=--:::.........:###++++++++++++++++++++++++=.....::..:.::...........:-............\n" +
                "=**+****+=-:::.........:###+++++++*++++++++++++++++=.....:-:::-::........::----:::........\n" +
                "=-=*****+==--:::::-....:###**#***#++++*++++++++++++=.....:-=---:.......::=++=*+=-:........\n" +
                "=--*++=+====++==-:.....:###*#####*+++++++++++++++++=......:=-==:.:::...--++++====::.......\n" +
                "=--=-=-=:--=++==--:....:########**++++**+++++++++++=......::::::::::::--=+=---:::.........\n" +
                "+===---=----=*---::....:###*###*++++++*++++++++++++=.......:.:...::-=--=-==-::............\n" +
                "++++==-=-=----::-::....:###+***+++++++*++++++++++++=...........:-:=-==-==--::.............\n" +
                "==--:::=::--:::........:###+++++++++++*++++++++++++=...........::.:-:::-:--:..............\n" +
                "::...:.::..:...........:###+++++++++++*++++++++++++=..............-:..:::..:..............\n" +
                "");
                System.out.println("You step on a seemingly unassuming pile of trash...");
                System.out.println("But a Trashsoldier jumps out!");
                gamePause();
                Character trashsoldierL2 = new Character("Trash Soldier", "Spear", "Waste Armor", 5, 50, 50, 10, 14, 7, 25, 2, 2, 0, 0, 0, 0);
                battleSimulation(player, playerextra, trashsoldierL2);
                player = afterBattle(player, playerextra, trashsoldierL2);
                player = incentives(player, trashsoldierL2);
                step1 = false;
            }

            else if (step == 2 && step2) {
                clearConsole();
                System.out.println("" +
                "==========================================================================================\n" +
                "=================================================================================+++***===\n" +
                "===================================================================+++***##%%%@@@@@@@@@===\n" +
                "=====================================================+++***##%%%@@@@@@@@@@@@@@@@@@@@@@@===\n" +
                "=======================================+++**###%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
                "====================================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
                "------==============================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===\n" +
                "....    ....:::::::::::...:-========*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%#+=.:=\n" +
                "...    ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@#%%%%%%%*-::-=+*#######=    #\n" +
                "..     ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@########.       .######*-::+#\n" +
                ".     ...............    ..-========*@@@@@@@@@@@@@@@@@@@@@@@@########=       *############\n" +
                "     ...............    ...:=========++++++*-   =************#########      =#############\n" +
                "    ................    ...-================:   -============#########-     *#############\n" +
                "    ...       .....    ....-================-  :=============#########+    +##############\n" +
                "   .....     .....    .....-=================. .=============##########   .###############\n" +
                "  ................    .....-=================-:-=============##########   -###############\n" +
                "  ...............    ..... .=================================##########=.:*###############\n" +
                " ...............    .::::   :.::==++=========================#############################\n" +
                "....  .........  .-=+++=:    .    :++========================#############################\n" +
                "...   ...:::-=-   ::::. .==++++=  ===========================#############################\n" +
                "...   -==+=-.         :++++*****--===========================#############################\n" +
                "-==   :..         ..  =*********-:===========================#############################\n" +
                "-.         :--=+++++. =**+***++=-:===========================######################  #####\n" +
                ".     .-=++++++*****- -++++=====--===========================##########+-:=#######-. =####\n" +
                "-.    ++++++*********:-====---==--===========================#######*-.  :*#######  -*####\n" +
                "+=   :++****++******+--=--::::::--:----======================######*  .=##########- =#####\n" +
                "+:   =*****+**+++===--::::::::.      :::::-------============#####+::-:..:*###*.+##+ +####\n" +
                "**=  -****+======--::..::::..         .::::::::::::-------===###+. :--=#= +###= -*#* =####\n" +
                "**- .****====---:::::. :::            ::::::::::::::::::::::-###++*##*=  --::##= :. +#####\n" +
                "***+**++==--:::::::::  ::.           .::::::::::::::::::::::-######+.  ..  .+#+  :. ######\n" +
                "+*+:.==--::::::.                    .:::::::::::::::::::::::-#######+*#*..+###+.   -######\n" +
                "===  ::::::::                   ..::::::::::::::::::::::::::-###############-.  .: *######\n" +
                "--:   :::::.                 .::::::::::::::::::::::::::::::-###########=-:. .:::. =######\n" +
                "");
                System.out.println("Going further in the comfort room, toilet paper and sink water spreads out chaotically in the vicinity...");
                System.out.println("A Rat mage emerges from the sink!");
                gamePause();
                Character ratmage2 = new Character("Rat Mage", "Reekburst", "Waste Armor", 6, 55, 55, 10, 11, 5, 30, 3, 3, 0, 0, 0, 0);
                battleSimulation(player, playerextra, ratmage2);
                player = afterBattle(player, playerextra, ratmage2);
                player = incentives(player, ratmage2);
                step1 = false;
            }

            else if (step == 3 && step3) {
                System.out.print("You feel an intense aura up ahead, and you passed by a janitor's stool, would you like to take a rest? (Y/N): ");
                step3 = false;
                choice = rd.readLine();
                choice = choice.toLowerCase();

                if (choice.equals("y") || choice.equals("yes")) {
                    System.out.println("You took a short rest");
                    player.mana = player.maxmana;
                    player.hp = player.maxhp;
    
                    boredom--;
                } else if ((choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") && boredom <= 0) {
                    System.out.println("You already felt the boredom from resting, you do not want to rest anymore...");
                    step3 = false;
                } else {
                    System.out.println("Strong men don't need rest anyway...");
                }
            }
            
            else if (step == 4 && step4) {
                System.out.println("You feel an intense aura up ahead, are you sure you want to go ahead? (Recommended level: 8+)\n");
                System.out.print("Go ahead? (Y/N): ");
                choice = rd.readLine();

                if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                    clearConsole();
                    System.out.println("" +
                    "++++++++++++++++:....................................................:++++++++++++++++-...\n" +
                    "++++++++++++++++:.............................................  .....:++==-::-:-++++++-...\n" +
                    "+++=======++++++:..........................................     .....:++-:.    .-=++++-...\n" +
                    "++=-::::-=++++++:......... ..............................      ......:++=:.   ..:-=+++-...\n" +
                    "+==-:...:-++++++:........   .......................... ..      ......:+++-::::-===++++-...\n" +
                    "++=:....:=++++++:......       .....................  .....     ......:+++=---=++++++++-...\n" +
                    "++=:...:-=++++++:......       ..................     ......     .....:++++----==++++++-...\n" +
                    "+++-::.:=+++++++:......       ................       ......     .....:++++=----=++++++-...\n" +
                    "+++=---=++++++++:......      .................      .......    ......:+++=--:--=++++++-...\n" +
                    "+++==--=++++++++:......     ............    ....    ........   ......:++++=--:--=+++++-...\n" +
                    "+++++===++++++++:.......   ............    .....     ................:++++=------=++++-...\n" +
                    "++++++++++++++++:................................   .................:++++=-::::-=++++-...\n" +
                    "++++++++++++++++:....................................................:+++++-:::-=+++++-...\n" +
                    "++++++++++++++++:....................................................:++++++===+++++++-...\n" +
                    "++++++++++++++++:.........................::::.......................:++++++++++++++++-...\n" +
                    "++++++++++++++++:....................:-=+++++++=-....................:++++++++++++++++-...\n" +
                    "++++++++++++++++:.............::::--++++++++++++++-..      ..........:++++++++++++++++-...\n" +
                    "++++++=+++++++++:...........:+++++++++===------==++-:.     ..........:++++++++++++++++-...\n" +
                    "+++++==+++++++++:...........=++++++++=-----------=++++++=   .........:+++++++**=-+***+-...\n" +
                    "++++++=+++++++++:....  .....++++++++--------------=++++++   .........:+++++++*+   ****-...\n" +
                    "+++++====+++++++:....    ...++++++++---------------++++++:   ..... ..:++++++++=   +*++=...\n" +
                    "++++++==--=+++++:...........=++++++=-------------:-+++++++-  ........:+++++++++   =+++=...\n" +
                    "++++++==---=++++:...........=+++++++------------: =++++++++  ........:+++++++++   -+++=...\n" +
                    "+++====-====++++:...........-++++++++-----------. +++++++++  ........:++++++++++=+++++-...\n" +
                    "+++==---===+++++:...........:+++++++++=---------  +++++++++: ........:+++---::=+++++++=...\n" +
                    "++++++=====+++++:............=+++++++++====----: .+++++++++..........:+++-....:=++++++=...\n" +
                    "++++++++==++++++:...      ...-+++++++++++=        -+++++++=..........:++===:..:-=+++++-...\n" +
                    "+++++====+++++++:...       ...=+++++++++=         :+++===-..... .....:++=--:--==++++++=...\n" +
                    "++++=---==++++++:...       ....:++++==-.           -++=.......    ...:++-:::--=-===+++=...\n" +
                    "++=-::..:-=+++++:.....    .....--:-=-.              :++.....      ...:++===------===++-...\n" +
                    "++=:.   :-++++++:......   ....   ....               :++.....     ....:+++++=-:::::-==+-...\n" +
                    "++=-.:::==++++++:.............  -++--            .:=+++..............:++++=-::...:-=++=...\n" +
                    "+++====+++++++++:.............  =+++++=::.       -+++++..............:++++++==-:-==+++=...\n" +
                    "");
                    System.out.println("Before you stands a toilet clogged way above the brim with toilet paper, someone's shoe, and..");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("a plunger..");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Withing the mass, a violent shaking occurs as you brace yourself for what's about to go down.");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("The Rat King jumps out!" + "\n");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    gamePause();
                    Character ratking = new Character("Rat King", "Rat-tling", "Rubbish Robe", 10, 75, 75, 8, 11, 8, 30, 4, 4, 0, 0, 0, 0);
                    battleSimulation(player, playerextra, ratking);
                    step4 = false;

                    epilogue(player, playerextra);

                } else if (choice.equals("4")) {
                } else {
                    System.out.println("Feeling afraid of the aura ahead, you decide to retreat...\n");
                    step--;
                }
            }

            else if (step > 4 || step < 0) {
                System.out.println(player.name + ": Can't go further...\n");
                if (step > 4) {
                    step--;
                } else if (step < 0) {
                    System.out.println(player.name + " went back to the main entrance\n");
                    mainhub(player, playerextra);
                }
            } else {
                System.out.println(player.name + ": This place is empty...\n");
            }

            gamePause();
            clearConsole();
        }
        return player;
    }

        public static Character mainfield(Character player, Extra playerextra) throws IOException {
            boolean step1 = true, step2 = true, step3 = true, step4 = true, step5 = true, explore = true, vacuum = true;
            String choice;
            int step = 0, boredom = 2;
    
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    
            while (explore) {
                clearConsole();
                System.out.println("" +
                "..........................................................................................\n" +
                "::.................................................................................::..:..\n" +
                ":..-::::-:::....................................................................:..::..::.\n" +
                " -::-....:..-:::-::::............................................................-..::..::.\n" +
                "-.::...::..-.::::.:..:....:...............................................:::...-..::...-.\n" +
                "-.::...:...-..-.-.-..:.:..:.::.:.::.:.............:::::::::....::::::-:-::..:...=..:-:::=:\n" +
                "-.-....-...-..-.-.-..:.:.:-:--:---::-:-------=-----=----=====-:-:-.-.-.-.-::-:..=...-...-.\n" +
                "=:=::..=:::=.:-:=.-..-.-.-:-=-:=-=:==-==+++==---=-:---::::-----+--:-:-:-.-::-:..-...=...-.\n" +
                "=:-:...=..:=..=:=:-..-.=.-:+++++=++==::::-=+++****#******++==-::-==+=+++-+==+-::=-::=..:=:\n" +
                "=:-:...=...=.:=-+*+-=+++-=+===-:::-=+++************************+=-::-=+****#==::-:..=..:=.\n" +
                "=:=::::=-::=::=+****+=-:....:-=+**********************************+=-:.:-+***++++=-==:::=:\n" +
                "=.=:..:++==*++=+=::.....:-=+*****************************************+-:..:-=+##**=-+-:-=:\n" +
                "=.=::::*++=-:........:-=+*************************%#*******************++:.....-++-:=-::=-\n" +
                "+==:==--....... ...:-+***************************#%#**********************=-......-+*+=+++\n" +
                "**=-:......    .::-=**************************************###*****+********+=.......:=***#\n" +
                "..........  ..:-=+***********************+++*********************************:........:-+#\n" +
                ".............-++********++***************************************************+....  .....-\n" +
                "..........:-++******+==+******************************************************-....  .....\n" +
                "...  .....-+++*******+********************************************************=:....  ....\n" +
                ".   ......-+******++*******************************##********##%%%%%%%#*******+:..........\n" +
                "   .....:=+*************************************************%%#%%%%%%%%#******+-..........\n" +
                "  .....-+***************************************************###+#%%%%##*******=-:.........\n" +
                " .......=*****************##***********************************+*************+-:.....  ...\n" +
                " .......-********************************************************************-:......  ...\n" +
                "........=*******************************#%##****+=+************************+-:.......  ...\n" +
                "........-+*********#%#*******************%%%******==***********************=:.......  ....\n" +
                ".......:-+***********************###***#%%%#******+**********************+-:........  ....\n" +
                "........-=+**********************####%%%%%%%#**************************++-.........  .....\n" +
                ".........:-=*******************#####%%%%%%%%%#**********************+==-...........  .....\n" +
                "  ........:-=+*****************######%%%%%%%%%#*******************+=-:....................\n" +
                "   .........:-==+***************#########%%%%##****************+=-:.......................\n" +
                ".   ............:-==++************************************++=-:...........................\n" +
                "..   ...............::-====+++++*******++++++++====-----:::....................  .........\n" +
                "");
                System.out.println("You are at what used to be the green football field, feels like a dump here, what do you want to do?");
                System.out.println("1. Go forward\n2. Go backward\n3. Go back to the main entrance\n4. Item Menu\n");
                System.out.print(player.name + ": ");
                choice = rd.readLine();
    
                if (choice.equals("1")) {
                    System.out.println(player.name + " went forward.\n");
                    step++;
                } else if (choice.equals("2")) {
                    System.out.println(player.name + " player went backward.\n");
                    step--;
                } else if (choice.equals("3")) {
                    System.out.println(player.name + " went back to the entrance.\n");
                    mainhub(player, playerextra);
                } else if (choice.equals("4")) {
                    itemMenu(player, playerextra);
                } else {
                    System.out.println("Incorrect input, try again...\n");
                }
    
                if (step == 1 && step1) {
                    clearConsole();
                    System.out.println("" +
                    "..........................................................................................\n" +
                    ":::::.................................................................................:...\n" +
                    "......-::.:::..-...:............................................................:-::::-...\n" +
                    "..:...-.:.-.-..-.:-:..-...........................:::::::::......::..-:=::--::=:.:....-...\n" +
                    ".:-:::=:-:=.-.::..-.::+:::-::-::::::--::..-:-:=:=---=:-+:--:::.:.:=::-.-..:...=..-...:=:::\n" +
                    "..-..:-.-.=:=:==+-=::-+:::=--=-=:---==-===+=+-+-==--=--==++++=--::+::-:-::-:::=::=:::.--..\n" +
                    "..=..:-.-:=:=.+:-:=::==---===+***+===-----==::-::::..::::---==-=-=+:-=:--:--::=:.=....:=..\n" +
                    ":-=::--:======+--=+=++++=-=-:--:-=-=--====+==++++++==++==::::::::-++==-==:--::=::=-:---+::\n" +
                    ".--..=--+++*****++*++---:.:::-=-++**********###**********+++++-::::::-=+++++*+**-+*++**+::\n" +
                    "=+=--+==++***+=-:.:::===++++************************************+==-:::::-++********##==-:\n" +
                    "**---=+=::.:..:--=+++***********************************************++=::...:-=++**##*+=+-\n" +
                    "-::.......:-==+*******************************************************+===-:...::=*####**+\n" +
                    "......::-=+***************************************************************+=:......-=+***#\n" +
                    "..:--=++*******************************************************************++--::.....:-=*\n" +
                    "-==+*****************************************%#******************************+*++-........\n" +
                    "+******************************************#%%%#********************************++-:......\n" +
                    "*******************************************####************************************=--....\n" +
                    "*********************************************************#####********++*************+=-..\n" +
                    "**********************************************************####***********************++=..\n" +
                    "*******************************==++****************************************************=..\n" +
                    "*****++**************************=****+*************************************************=:\n" +
                    "*++++++*********************************************************************************+:\n" +
                    "-=+**************************************************************************************=\n" +
                    "+***************************************************************************************+=\n" +
                    "*****************************************************************************************+\n" +
                    "**********************************************####**************##%%%#%%%%%%#*************\n" +
                    "*************************************************************#%%%%%%%%%%%%%%%%***********+\n" +
                    "************************************************************%%####%%%%%%%%%%%%#**********+\n" +
                    "************************************************************#%%%%#*#%%%%%%%%%##**********+\n" +
                    "********##*****************************************************#*==#########************+=\n" +
                    "******###********************************************************+++#******************++-\n" +
                    "***************************************************************************************+-:\n" +
                    "***************************************************************************************=::\n" +
                    "");
                    System.out.println("Something starts moving within the pile of trash in front of you.");
                    System.out.println("A trashman strikes you from behind!");
                    gamePause();
                    Character trashman3 = new Character("Trashman", "Sword", "Trash Tunic", 3, 30, 30, 4, 6, 5, 10, 1, 1, 0, 0, 0, 0);
                    battleSimulation(player, playerextra, trashman3);
                    player = afterBattle(player, playerextra, trashman3);
                    player = incentives(player, trashman3);
                    step1 = false;
                }
    
                else if (step == 2 && step2) {
                    clearConsole();
                    System.out.println("" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "....................................................................::.......-....:.::-=--\n" +
                    "...:=.....:..................................-:::::::..-...........:-:...=::-+----=-::.=..\n" +
                    "::-=+--:::=...:.........:.::.:...-.:-=--=-=--=--+-::*=:=::-..:..:...-=--:=:..=....-....+..\n" +
                    "...+-...::+--==--=---=--=-=-:-:-:=::=--==-=--=--+---+=-=-=+===::-::.:=:..=...=....=....+..\n" +
                    "---*-----=+--=+--=---=:-=-+--==-=++=+--+=-=-=---+---+==+=+*+++=-=-::-+-::=:::=-::-=::::+::\n" +
                    "::=+=----=====*****++====-==-=---+++-::-:.:::::::::::::=====++--=----+-:-+:::=-::-=....+..\n" +
                    "-=++-----+===++++++++=-=-:::----:-::::--------:...::::......:::-====++-::+:..--..-+---:+-:\n" +
                    "++++++=--=--:::::.:---==-===++++++++++++++++**+++++**+==-:::::...:..:=++++===+=-::+-:-:=-.\n" +
                    "**+===-....:::---:=++++**************%%#***************+++++=+=-:......:-=+++++=+=*++++**+\n" +
                    "-:..::::::-====++++******************###***********************++==--::::.::-=++**********\n" +
                    " :-===+++++++**************************************+****************+++--:::::..:-+=*******\n" +
                    "++*********************************************************************+++=--::....::=++*+\n" +
                    "***************************************************************************+=-::::.....:=+\n" +
                    "***************************************************************************++==+=-:::.....\n" +
                    "**********##*********************************************************************==-:.....\n" +
                    "****************************************************+*****************************+=-::::.\n" +
                    "**************************************#********************************************++===::\n" +
                    "*************************************#%#*********************************************+++==\n" +
                    "************************************#%%%#*************************************************\n" +
                    "**********************************#%%%%%%#************************************************\n" +
                    "***********************************#%%%%#*************************************************\n" +
                    "**********************************************************####*************=+=************\n" +
                    "*******************************************************########************++*************\n" +
                    "*********************************************************######***************************\n" +
                    "*****************++++*++******************************************************************\n" +
                    "");
                    System.out.println("Continuing further, you pass by a bench, would you like to take a rest? (Y/N)");
                    System.out.print(player.name + ": ");
                    choice = rd.readLine();
                    choice = choice.toLowerCase();

                    if ((choice.equals("y") || choice.equals("yes")) && boredom > 0) {
                        System.out.println("You took a short rest");
                        player.setMana(player.getMaxmana());
                        player.setHp(player.getHp() + 20);

                        if (player.getHp() > player.getMaxhp()) {player.setHp(player.getMaxhp());}
        
                        boredom--;
                    } else if ((choice.equals("y") || choice.equals("yes")) && boredom == 0) {
                        System.out.println("You already felt the boredom from resting, you do not want to rest anymore...");
                        step3 = false;
                    } else {
                        System.out.println("Strong men don't need rest anyway...");
                    }
                }

                else if (step == 3 && step3) {
                    clearConsole();
                    System.out.println("" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "....................................................................::.......-....:.::-=--\n" +
                    " ...:=.....:..................................-:::::::..-...........:-:...=::-+----=-::.=..\n" +
                    "::-=+--:::=...:.........:.::.:...-.:-=--=-=--=--+-::*=:=::-..:..:...-=--:=:..=....-....+..\n" +
                    "...+-...::+--==--=---=--=-=-:-:-:=::=--==-=--=--+---+=-=-=+===::-::.:=:..=...=....=....+..\n" +
                    "---*-----=+--=+--=---=:-=-+--==-=++=+--+=-=-=---+---+==+=+*+++=-=-::-+-::=:::=-::-=::::+::\n" +
                    "::=+=----=====*****++====-==-=---+++-::-:.:::::::::::::=====++--=----+-:-+:::=-::-=....+..\n" +
                    "-=++-----+===++++++++=-=-:::----:-::::--------:...::::......:::-====++-::+:..--..-+---:+-:\n" +
                    " ++++++=--=--:::::.:---==-===++++++++++++++++**+++++**+==-:::::...:..:=++++===+=-::+-:-:=-.\n" +
                    "**+===-....:::---:=++++**************%%#***************+++++=+=-:......:-=+++++=+=*++++**+\n" +
                    "-:..::::::-====++++******************###***********************++==--::::.::-=++**********\n" +
                    ":-===+++++++**************************************+****************+++--:::::..:-+=*******\n" +
                    "++*********************************************************************+++=--::....::=++*+\n" +
                    "***************************************************************************+=-::::.....:=+\n" +
                    "***************************************************************************++==+=-:::.....\n" +
                    "**********##*********************************************************************==-:.....\n" +
                    "****************************************************+*****************************+=-::::.\n" +
                    "**************************************#********************************************++===::\n" +
                    "*************************************#%#*********************************************+++==\n" +
                    "************************************#%%%#*************************************************\n" +
                    "**********************************#%%%%%%#************************************************\n" +
                    "***********************************#%%%%#*************************************************\n" +
                    "**********************************************************####*************=+=************\n" +
                    "*******************************************************########************++*************\n" +
                    "*********************************************************######***************************\n" +
                    "*****************++++*++******************************************************************\n" +
                    "");
                    System.out.println("You seem to see a beam of light emanating from a pile of trash.");
                    System.out.println("A Trashman jumps out!");
                    gamePause();
                    Character trashmanL4 = new Character("Trashman", "Spear", "Waste Armor", 3, 40, 40, 5, 7, 5, 15, 1, 1, 0, 0, 0, 0);
                    battleSimulation(player, playerextra, trashmanL4);
                    player = afterBattle(player, playerextra, trashmanL4);
                    player = incentives(player, trashmanL4);
                    step3 = false;
                }
                
                else if (step == 5 && step5) {
                    clearConsole();
                    System.out.println("" + 
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    "..........................................................................................\n" +
                    ".................................................-....................:-..................\n" +
                    "................................:.....:..........+.:....-:......::....:+....:.............\n" +
                    "........................=.......+:::--+=-===+++++*++++++*+=====+**+---=+-:::+::...........\n" +
                    ".....+....:=::..:-......=:.:====+-----+=::::*...-+..:::-*=:..:.-*#-.:.-+....+.....--......\n" +
                    "-----+=====*-:..:+...:..=:.....=-....:*:...:*::.-+:::::-*=:::.:.+*=:::=*::.:+:.:::+-......\n" +
                    "-----+::::=+:.:.-+::---:+=:.:::+=::--=*=-===*==-++======*======-++====+*====*=====+=--::.:\n" +
                    ":::::+-==-++=-=-=*+++==-++=++++*+====+*=====*===*+=====+*+======++=-+-=*-==+*+++++*==---:-\n" +
                    "-----*=---*=----+*----=-*+==+=++-=---++-::-=+::-+-:::::=*-:::---++====+*+=+******+*++-:::-\n" +
                    "-::--*---=*---=-=*:-==+=*=++++*=:-:::=+-::::-::-==--:---==---=::=+=---=*++++*+++++*+====-=\n" +
                    "==-==*--:-==+=--=+-=---=*==+++=-:::-----:..:::::::...:::::::::::--:::-==++====-=++++-:--:-\n" +
                    "+++++=+=---:-:.:--:-:---=-==--:::.::::::::::::::::...................:::-::---=++++*+=+---\n" +
                    "=--=+=--::::.-::---::=::-::.:.::.:.-:-:-----=----=-:........:::::.::............::::::----\n" +
                    ":--:-:::-::::-=-=+-===-====--:---==+==========+=+++=-=--:::--=-=-:=::.:.................:-\n" +
                    "-===--:-=-=-==++=+++===+++++++=+++=++++++++++++++**++++++++++****+====-::-:-:::::-.:....:.\n" +
                    "=+++==+++++=++*++*+*+++++*********************************************+==-----=---:-:::::.\n" +
                    "++**++++***++*******************#%%%#*********************************=+===+++++=-=++--:::\n" +
                    "********************************%%%%%%#**************************************++++++**++-:-\n" +
                    "********************************%%+%%##***********************************************+++=\n" +
                    "*****************************************************************************************+\n" +
                    "****************************#******************************=+++***************************\n" +
                    "******************************************************************************************\n" +
                    "******************************************************************************************\n" +
                    "******************************************************************************************\n" +
                    "******************************************************************************************\n" +
                    "");
                    System.out.println("The light was not caused by the Trashman... No, it couldn't possibly be...");
                    System.out.println("Your thoughts halt as a Trashsoldier jumps out!");
                    gamePause();
                    Character trashsoldier = new Character("Trash Soldier", "Sword", "Waste Armor", 4, 45, 45, 6, 7, 5, 10, 1, 1, 0, 0, 0, 0);
                    battleSimulation(player, playerextra, trashsoldier);
                    player = afterBattle(player, playerextra, trashsoldier);
                    player = incentives(player, trashsoldier);
                    step5 = false;

                    if (!player.getWpn().equals("Vacuum Cleaner")) {
                        System.out.println("You find the source of the light, it is a miracle that something this pure could be among the gunk in the field.");
                        try {
                            Thread.sleep(600);
                            System.out.print(".");
                            Thread.sleep(800);
                            System.out.print(".");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        ascii("Vacuum");
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("After inspecting, you cannot believe your eyes! You found the Clean-inator 9000, the cleaner of legends!\n");
                        System.out.println("Would you like it equipped? (Y/N)\n");
                        System.out.print(player.name + ": ");
                        choice = rd.readLine();
                        
                        if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                            System.out.println(player.name + ": Hell yeah!\n");
                            System.out.println(player.name + " obtained the Clean-inator 9000!\n");
                            player.setWpn("Vacuum Cleaner");
                            vacuum = false;
                        } else {
                            System.out.println("You chose to reject the easy way...\n");
                            vacuum = true;
                        }
                    }
                    
    
                    } else if (step == 5 && step5 == false && !player.getWpn().equals("Vacuum Cleaner")) {
                        ascii("Vacuum");
                        System.out.println(player.name + ": The Clean-inator 9000 is still lying there...");
                        System.out.print("Would you like it equipped? (Y/N): ");
                        choice = rd.readLine();
                    
                        if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                            System.out.println(player.name + ": Hell yeah!\n");
                            System.out.println(player.name + " obtained the Clean-inator 9000!\n");
                            player.setWpn("Vacuum Cleaner");
                            vacuum = false;
                        } else {
                            System.out.println("Strong men don't need an easy game...\n");
                        }
                    }
    
                else if (step > 5 || step < 0) {
                    System.out.println(player.name + ": Can't go further...\n");
                    if (step > 5) {
                        step--;
                    } else if (step < 0) {
                        System.out.println(player.name + " went back to the main entrance\n");
                        mainhub(player, playerextra);
                    }
                } else if (choice.equals("4")) {
                } else {
                    System.out.println(player.name + ": This place is empty...\n");
                }
    
                gamePause();
                clearConsole();
            }
        return player;
    }

    static void epilogue(Character player, Extra playerextra) {
        clearConsole();
        ascii("Principal");

        System.out.println("Principal: You have slain the rat king, " + player.name + "...");
        System.out.println("Principal: The rat king has been a problem, being the main reason why trash men, trash soldiers, and rat mages have been multiplying.");
        System.out.println("Principal: Good job, you have used your critical and logical thinking to rid the problem of which janitors had trouble over.");
        System.out.println("Principal: Expect that you will pass 8th grade.");

        gamePause();
        clearConsole();

        System.out.println("Narrator: The young boy has managed to defeat the Rat King and has managed to clean the school...\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Narrator: With that, the young boy " + player.name + " managed to fulfill their community service and saved the school from its grimy threats...\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Narrator: The end... for now..");
        System.out.println("\nPrincipal: Congratulations on beating Adventure Mode on " + playerextra.getDifficulty() + ".");
        System.out.println("Narrator: You have finished TrashFighters Version 1.1!\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Please restart the game to play a new game.");
        System.exit(0);
    }

    public static Character incentives(Character player, Character enemy) throws IOException {
        String bless = "N/A";
        int tries = 3;

        if (player.getLvl() <= (enemy.getLvl() + 1)) {
            while (tries > 0) {
                clearConsole();
                ascii("Principal");
                System.out.println("Principal: Welcome, " + player.getName() + "...");
                System.out.println("Principal: For cleaning up trash in the school, I shall give you incentives! Choose wisely, you have " + tries + " left");
                System.out.println("1. Improve ATK");
                System.out.println("2. Improve DEF");
                System.out.println("3. Improve SPD");
                System.out.println("4. Improve HP");
                System.out.println("5. Improve Recovery");
                System.out.println("6. Improve MANA");

                System.out.println("Principal: Enter your choice, student...");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(player.getName() + "'s choice: ");
                bless = reader.readLine();

                System.out.println("Principal: Here, take this...\n");

                if (bless.equals("1")) {
                    System.out.println(player.getName() + " feels stronger!\n");
                    player.setPow(player.getPow() + 1);

                    if (player.getPow() > player.getMaxpow()) {
                        System.out.println(player.getName() + "'s ATK cannot be increased! \n");
                        player.setPow(player.getMaxpow());
                        tries++;
                    }
                    tries--;
                } else if (bless.equals("2")) {
                    System.out.println(player.getName() + " feels bulkier!\n");
                    player.setDef(player.getDef() + 1);

                    if (player.getDef() > player.getMaxdef()) {
                        System.out.println(player.getName() + "'s DEF cannot be increased! \n");
                        player.setDef(player.getMaxdef());
                        tries++;
                    }
                    tries--;
                } else if (bless.equals("3")) {
                    System.out.println(player.getName() + " feels faster!\n");
                    player.setSpd(player.getSpd() + 1);

                    if (player.getSpd() > player.getMaxspd()) {
                        System.out.println(player.getName() + "'s SPD cannot be increased! \n");
                        player.setSpd(player.getMaxspd());
                        tries++;
                    }
                    tries--;
                } else if (bless.equals("4")) {
                    System.out.println(player.getName() + " feels vitalized!\n");
                    player.setMaxhp(player.getMaxhp() + 5);
                    player.setHp(player.getHp() + 5);
                    tries--;
                } else if (bless.equals("5")) {
                    System.out.println(player.getName() + " feels more resilient!\n");
                    player.setRec(player.getRec() + 5);
                    tries--;
                } else if (bless.equals("6")) {
                    System.out.println(player.getName() + " feels more energetic!\n");
                    player.setMaxmana(player.getMaxmana() + 1);
                    player.setMana(player.getMana() + 1);
                    tries--;
                } else {
                    System.out.println("Principal: Wait, that's wrong\n");
                }

                gamePause();
                clearConsole();
            }

            System.out.println("--------\n");
            System.out.println(player.name + "'s stats\n");
            System.out.println("LVL: " + player.lvl + "\n");
            System.out.println("HP: " + player.hp + " / " + player.maxhp + "\n");
            System.out.println("MANA: " + player.mana + " / " + player.maxmana + "\n");
            System.out.println("WEAPON: " + player.wpn + "\n");
            System.out.println("ARMOR: " + player.armor + "\n");
            System.out.println("ATK: " + player.pow + "\n");
            System.out.println("DEF: " + player.def + "\n");
            System.out.println("SPD: " + player.spd + "\n\n");
            System.out.println("--------\n");

        } else {
            System.out.println("System: No incentives due to being too higher leveled than the enemy.\n");
        }
        return player;
    }

    public static Character bookstore(Character player, Extra playerextra) throws IOException {
        boolean shop = true; String itemClaimed = "N/A"; 
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while(shop) {
            clearConsole();
            boolean check = false;
            ascii("Merchant");

            System.out.println("Merchant: Well, well, if it isn't my favorite customer!");
            System.out.println("Merchant: Today, I've got useful goods to help you in your quest to clean the school");
            System.out.println("Merchant: Remember, no refunds and no reselling, so make your choice count!");
            System.out.println(player.getName() + ": What should I do?");
            System.out.println("1. Buy items\n2. Check your stats\n3. Use items\n4. Leave");
            System.out.print(player.getName() + ": ");
            String choice = rd.readLine();

            if (choice.equals("1")) {
                clearConsole(); ascii("Merchant");
                System.out.println("---------------------------------------------");
                System.out.println("[1] Heal Pass - P75 - "+ itemDefinition("Heal Pass"));
                System.out.println("[2] PE Uniform - P200 - " + itemDefinition("PE Uniform"));
                System.out.println("[3] Lesson in Logical Thinking - P80 - " + itemDefinition("Lesson in Logical Thinking"));
                System.out.println("[4] Lesson in Critical Thinking - P150 - " + itemDefinition("Lesson in Critical Thinking"));
                System.out.println("[5] Face Mask - P90 - " + itemDefinition("Face Mask"));
                System.out.println("[6] Rubber Gloves - P150 - " + itemDefinition("Rubber Gloves"));
                System.out.println("[7] List of Deadlines - P70 - " + itemDefinition("List of Deadlines"));
                System.out.println("[8] Energy Drink - P150 - " + itemDefinition("Energy Drink"));
                System.out.println("[9] White Flower - P50 - " + itemDefinition("White Flower"));
                System.out.println("[10] Biogesic  - P125 - " + itemDefinition("Biogesic"));
                System.out.println("[Other] Go back");
                System.out.println("---------------------------------------------");

                System.out.println(player.getName() + ": I have P" + playerextra.getMoney() + ", what should I buy?");
                System.out.print(player.getName() + ": ");
                choice = rd.readLine();
                System.out.println("---------------------------------------------");

                if (choice.equals("1") && playerextra.getMoney() >= 75) {
                    System.out.println(player.getName() + " bought a Heal Pass");
                    playerextra.setHpass(playerextra.getHpass() + 1);
                    playerextra.setMoney(playerextra.getMoney() - 75);
                } else if (choice.equals("2") && playerextra.getMoney() >= 200) {
                    System.out.println(player.getName() + " bought a PE Uniform");
                    player.setArmor("PE Uniform");
                    playerextra.setMoney(playerextra.getMoney() - 200);
                } else if (choice.equals("3") && playerextra.getMoney() >= 80) {
                    System.out.println(player.getName() + " bought a Lesson in Logical Thinking");
                    itemClaimed = "Lesson in Logical Thinking";
                    playerextra.setMoney(playerextra.getMoney() - 80);
                    check = true;
                } else if (choice.equals("4") && playerextra.getMoney() >= 150) {
                    System.out.println(player.getName() + " bought a Lesson in Critical Thinking");
                    itemClaimed = "Lesson in Critical Thinking";
                    playerextra.setMoney(playerextra.getMoney() - 150);
                    check = true;
                } else if (choice.equals("5") && playerextra.getMoney() >= 90) {
                    System.out.println(player.getName() + " bought a Face Mask");
                    itemClaimed = "Face Mask";
                    playerextra.setMoney(playerextra.getMoney() - 90);
                    check = true;
                } else if (choice.equals("6") && playerextra.getMoney() >= 150) {
                    System.out.println(player.getName() + " bought a Rubber Gloves");
                    itemClaimed = "Rubber Gloves";
                    playerextra.setMoney(playerextra.getMoney() - 150);
                    check = true;
                } else if (choice.equals("7") && playerextra.getMoney() >= 70) {
                    System.out.println(player.getName() + " bought a List of Deadlines");
                    itemClaimed = "List of Deadlines";
                    playerextra.setMoney(playerextra.getMoney() - 70);
                    check = true;
                } else if (choice.equals("8") && playerextra.getMoney() >= 150) {
                    System.out.println(player.getName() + " bought an Energy Drink");
                    itemClaimed = "Energy Drink";
                    playerextra.setMoney(playerextra.getMoney() - 150);
                    check = true;
                } else if (choice.equals("9") && playerextra.getMoney() >= 50) {
                    System.out.println(player.getName() + " bought a White Flower");
                    itemClaimed = "White Flower";
                    playerextra.setMoney(playerextra.getMoney() - 50);
                    check = true;
                } else if (choice.equals("10") && playerextra.getMoney() >= 125) {
                    System.out.println(player.getName() + " bought a Biogesic");
                    itemClaimed = "Biogesic";
                    playerextra.setMoney(playerextra.getMoney() - 125);
                    check = true;
                } else if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8") || choice.equals("9") || choice.equals("10")) {
                    System.out.println(player.getName() + " I don't have the money for that...");
                }                
                
                for (int i = 0; i < 3 && check == true; i++) {
                    String playerInv = playerextra.items[i];
                    if (playerInv.equals("N/A")) {
                        playerextra.items[i] = itemClaimed;
                        check = false;
                    }

                    if (i == 2 && !playerInv.equals("N/A")) {
                        System.out.println(player.name + ": Ah, I dont have any space.");
                    }
                }
                System.out.println("---------------------------------------------");
                gamePause();
            } else if (choice.equals("2")) {
                clearConsole();
                checkStats(player, playerextra);
                gamePause();
            } else if (choice.equals("3")) {
                clearConsole();
                itemMenu(player, playerextra);
            } else if (choice.equals("4")) {
                System.out.println("---------------------------------------------");
                System.out.println(player.name + ": Pleasure doing business with you, as always.");
                System.out.println("Merchant: Likewise! And remember, if you ever need more of my goods, you know where to find me. Safe travels, adventurer!");
                shop = false;
                gamePause();
            } else {
                System.out.println("---------------------------------------------");
                System.out.println(player.name + ": Wait, what am I thinking?");
                gamePause();
            }
        }

        return player;
    }

    public static void checkStats(Character player, Extra playerextra) {
        System.out.println("--------");
        System.out.println(player.name + "'s stats");
        System.out.println("LVL: " + player.lvl);
        System.out.println("HP: " + player.hp + " / " + player.maxhp);
        System.out.println("MANA: " + player.mana + " / " + player.maxmana);
        System.out.println("ARMOR: " + player.armor);
        System.out.println("WEAPON: " + player.wpn);
        System.out.println("ATK: " + player.pow);
        System.out.println("DEF: " + player.def);
        System.out.println("SPD: " + player.spd);
        System.out.println("--------");
        System.out.println("Skill 1: " + playerextra.skills[0]);
        System.out.println("Skill 2: " + playerextra.skills[1]);
        System.out.println("Skill 3: " + playerextra.skills[2]);

        if (playerextra.getMode().equals("Game")) {
            System.out.println("--------");
            System.out.println("MONEY: P" + playerextra.money);
            System.out.println("Item 1: " + playerextra.items[0] + " - " + itemDefinition(playerextra.items[0]));
            System.out.println("Item 2: " + playerextra.items[1] + " - " + itemDefinition(playerextra.items[1]));
            System.out.println("Item 3: " + playerextra.items[2] + " - " + itemDefinition(playerextra.items[2]));
        }
    }

    public static Character itemMenu(Character player, Extra playerextra) throws IOException {
        boolean menu = true;

        while (menu) {
            clearConsole();
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Item Menu: ");
            System.out.println("Item 1: " + playerextra.items[0] + " - " + itemDefinition(playerextra.items[0]));
            System.out.println("Item 2: " + playerextra.items[1] + " - " + itemDefinition(playerextra.items[1]));
            System.out.println("Item 3: " + playerextra.items[2] + " - " + itemDefinition(playerextra.items[2]));
            System.out.println("[1/2/3] - Use item\n[4] - Check your stats\n[0] - Leave");
            System.out.print(player.name + ": What should I use?: ");
            String choice = rd.readLine();

            if (choice.equals("1")) {
                String item1 = playerextra.items[0];
                useItems(item1, player, playerextra, 0);
            } else if (choice.equals("2")) {
                String item2 = playerextra.items[1];
                useItems(item2, player, playerextra, 1);
            } else if (choice.equals("3")) {
                String item3 = playerextra.items[2];
                useItems(item3, player, playerextra, 2);
            } else if (choice.equals("4")){
                clearConsole();
                checkStats(player, playerextra);
                gamePause();
            } else if (choice.equals("0")){
                menu = false;
            } else {
                System.out.println("Incorrect input, try again.");
            }
        }

        return player;
    }

    public static Character useItems(String item, Character player, Extra playerextra, int itemIndex) {
        if (item.equals("Lesson in Logical Thinking") && player.getPow() < player.getMaxpow()) {
            System.out.println(player.getName() + "'s power was boosted."); 
            player.setPow(player.getPow() + 1); 
        }
        if (item.equals("Lesson in Critical Thinking")) {
            System.out.println(player.getName() + "'s potential power was strengthened."); 
            player.setMaxpow(player.getMaxpow() + 5);
        }
        if (item.equals("Face Mask") && player.getPow() < player.getMaxpow()) {
            System.out.println(player.getName() + "'s defense was boosted."); 
            player.setDef(player.getDef() + 1); 
        }
        if (item.equals("Rubber Gloves")) {
            System.out.println(player.getName() + "'s potential defense was strengthened."); 
            player.setMaxdef(player.getMaxdef() + 5);
        }
        if (item.equals("List of Deadlines") && player.getPow() < player.getMaxpow()) {
            System.out.println(player.getName() + "'s speed was boosted."); 
            player.setSpd(player.getSpd() + 1);
        }
        if (item.equals("Energy Drink")) {
            System.out.println(player.getName() + "'s potential speed was strengthened."); 
            player.setMaxspd(player.getMaxspd() + 5);
        }
        if (item.equals("White Flower")) {
            System.out.println("Healed 15 HP and 2 MANA");
            player.setHp(player.getHp() + 15); player.setMana(player.getMana() + 2);
        }
        if (item.equals("Biogesic")) {
            System.out.println("Healed 40 HP and 4 MANA");
            player.setHp(player.getHp() + 40); player.setMana(player.getMana() + 4);
        }
        if (item.equals("N/A")) {System.out.println("There is no item set here.");}
        if (player.hp > player.maxhp) {player.setHp(player.getMaxhp());}
        if (player.mana > player.maxmana) {player.setMana(player.getMaxmana());}

        gamePause();
        playerextra.items[itemIndex] = "N/A";
        return player;
    }

    public static String itemDefinition(String item) {
        String definition = "";
        if (item.equals("Heal Pass")) {definition = "Allows the player to fully recover in the Clinic.";}
        if (item.equals("PE Uniform")) {definition = "Reduces damage equal to players level.";}
        if (item.equals("Lesson in Logical Thinking")) {definition = "Boost's the user's POW by 1";}
        if (item.equals("Lesson in Critical Thinking")) {definition = "Boost's the user's maximum POW by 5";}
        if (item.equals("Face Mask")) {definition = "Boost's the user's DEF by 1";}
        if (item.equals("Rubber Gloves")) {definition = "Boost's the user's maximum DEF by 5";}
        if (item.equals("List of Deadlines")) {definition = "Boost's the user's SPD by 1";}
        if (item.equals("Energy Drink")) {definition ="Boost's the user's maximum SPD by 5";}
        if (item.equals("White Flower")) {definition = "Heals the player by 15 HP and 2 MANA.";}
        if (item.equals("Biogesic")) {definition = "Heals the player by 40 HP and 4 MANA.";}
        if (item.equals("N/A")) {definition = "There is nothing here.";}
        return definition;
    }
}

