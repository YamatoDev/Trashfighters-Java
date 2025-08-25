#include <iostream>
#include <cstdlib>
#include <stdlib.h>
#include <ctime>
#include <windows.h>
using namespace std;

struct Character {
    string name, wpn;
    int lvl, hp, maxhp, pow, def, spd, rec, mana, maxmana, exp, maxpow, maxdef, maxspd;
};

struct Skills {
    string skill1, skill2, skill3, difficulty, mode;
    int hpass;
};

void gameload ();
Character firstpart(Character &player, Skills &playerskill, string choice); //determines difficulty
Character bossrush(Character &player, Skills &playerskill); //boss rush mode
Character mainhub(Character &player, Skills &playerskill);
Character maincroom(Character &player, Skills &playerskill);
Character mainfield(Character &player, Skills &playerskill);
Character mainbroom(Character &player, Skills &playerskill);
void ascii(Character &enemy);
void gameover ();
void epilogue (Character &player);
int battleSimulation(Character &player, Skills&playerskill, Character &enemy); //for the battle sequence
int difficulty(Character &player, Skills&playerskill, Character &enemy);
int attackSimulation(Character &player, Skills&playerskill, Character &enemy);
int skillSimulation(Character &player, Skills&playerskill, Character &enemy, string choice);
int damage(int atk, string wpn, int def, int lvl); //for checking damage values
void nextlvl (int lvl); //for asking to continue
Character levelUp(Character &player, Skills&playerskill, Character &enemy); // level up
Character blessing(Character &player, Skills &playerskill, int floor); //blessing for boss rush
Character incentive(Character &player, Character &enemy); //blessing for main game


int main() {
    bool game = true, load = false;
    string choice;

    gameload();


    while (game) {
        cout << R"(
=======================================================================
||                                                                   ||
||  _______            _     ______ _       _     _                  ||
|| |__   __|          | |   |  ____(_)     | |   | |                 ||
||    | |_ __ __ _ ___| |__ | |__   _  __ _| |__ | |_ ___ _ __ ___   ||
||    | | '__/ _` / __| '_ \|  __| | |/ _` | '_ \| __/ _ \ '__/ __|  ||
||    | | | | (_| \__ \ | | | |    | | (_| | | | | ||  __/ |  \__ \  ||
||    |_|_|  \__,_|___/_| |_|_|    |_|\__, |_| |_|\__\___|_|  |___/  ||
||                                     __/ |                         ||
||                                    |___/                          ||
=======================================================================
)" << '\n';
        cout << "VERSION 1\n\n";
        cout << "1. Adventure Mode\n";
        cout << "2. Boss Rush Mode\n";
        cout << "3. Quit\n";

        cout << "System: Enter your choice -- ";
        cin >> choice;

        cout << "Loading...";
        Sleep(2000);
        system("cls");

        Character player = {"Man", "Broomstick", 1, 30, 30, 3, 0, 5, 20, 2, 2, 0, 20, 20, 20};
        Skills playerskill = {"N/A", "N/A", "N/A", "BLANK", "BLANK", 0};

        if (choice == "1") {
            playerskill.mode = "Game";
            firstpart(player, playerskill, choice);

            cout << "Narrator: Once upon a time, there was a creative young boy named Johnny Thor Dela Cruz who had notoriously bad grades...\n";
            Sleep(2000);
            cout << "Narrator: The boy was then granted another chance by the principal, with the principal promising the boy that he would pass 8th grade if he were to clean the school as community service...\n";
            Sleep(2000);
            cout << "Narrator: Johnny accepted the proposal posthaste, but little did the boy know, it turns out it wasnt just ordinary trash and grime he has to clean...\n";
            Sleep(2000);
            cout << "Narrator: The boy has to fight trash-themed monsters, and they were no slouch either...\n";
            Sleep(2000);
            cout << "Narrator: So the boy set out, to clean the school...\n";
            Sleep(2000);

            system("pause");
            system("cls");

            cout << "Narrator: The boy starts off in the school entrance...\n";

            mainhub(player, playerskill);

        } else if (choice == "2") {
            playerskill.mode = "BossRush";
            firstpart(player, playerskill, choice);

            cout << "System: Are you familiar with the Boss Rush Minigame? (Y/N): ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << "System: Enjoy the Boss Rush Minigame! \n";
            } else {
                cout << "System: The minigame will pit you against 10 fights in a row, without stopping or exploration.\n";
                Sleep(1000);
                cout << "System: Don't worry, you will still have your blessings and levelling up.\n";
                Sleep(1000);
                cout << "System: In addition, mana and HP will be fully recovered after every battle.\n";
                Sleep(1000);
            }

            system("pause");
            system("cls");

            bossrush(player, playerskill);

            system("cls");
            cout << R"(
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
--------------------------------=+++*****++==---------------------------------------------
----------------------------=+*****************=------------------------------------------
---------------------------***********+++===+***+-----------------------------------------
---------------------------******-.            =*=----------------------------------------
--------------------------=*****:               +=----------------------------------------
--------------------------=****=                :=----------------------------------------
---------------------------+**-                 .=----------------------------------------
---------------------------:=-                   -----------------------------------------
---------------------------:-:                  =-----------------------------------------
---------------------------+*-    .:-=====-::  :*-----------------------------------------
----------------------------**:   +*=-----=+*--**-----------------------------------------
----------------------------***=:.*+       .****+=----------------------------------------
-------------------------====+*****=..=*+:-+***+=====.::----------------------------------
--------------------:..==========************=======-    .:-------------------------------
-------------:::::.    .======== .+********=.-======.     : .-----------------------------
------------   . ..-:   .=======:  .=****+.  ======:     :.  .-=--------------------------
-----------:        .=.  .=======    =++=:  :======      =-*%@@@@@@#+---------------------
-----------          :=   :======:   ====:  ======.  .+#@@@@@@@@@@@@@@#-------------------
----------:           =:   :======.  ====- -=====. -#@@###*#@@@@@@@@@@@@+-----------------
----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------
---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------
---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------
---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------
--------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------
---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------
---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------
--------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------
--------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------
--------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+.  :@@@@@@@@@@@@@@*-------------------
--------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------
)" << '\n';
            cout << "\nPrincipal: You have slain the rat king, student " << player.name << "...\n";
            cout << "\nPrincipal: Good job, you have used your critical and logical thinking!\n";
            cout << "\nPrincipal: Congratulations on beating the Boss Rush Minigame on " << playerskill.difficulty << ".\n";
            system("pause");
            system("cls");

            return 0;

        } else if (choice == "3") {
            cout << "System: Thank you for playing Trashfighters Version 1!\n";
            system("pause");
            return 0;

        }
    }
}

Character bossrush(Character &player, Skills &playerskill) {
    int floor = 1;

    //level 1
    cout << "----Floor " << floor << "----\n";
    Character trashman = {"Trashman", "Stick", 1, 25, 25, 3, 0, 4, 5, 0, 0, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashman);
    floor++;
    player = levelUp(player, playerskill, trashman);
    player = blessing(player, playerskill, floor);

    //level 2
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character trashmanL2 = {"Trashman", "Stick", 2, 30, 30, 4, 1, 4, 5, 0, 0, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashmanL2);
    player = levelUp(player, playerskill, trashmanL2);
    player = blessing(player, playerskill, floor);


    //level 3
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character trashmanL3 = {"Trashman", "Sword", 3, 35, 35, 4, 3, 5, 10, 1, 1, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashmanL3);
    player = levelUp(player, playerskill, trashmanL3);
    player = blessing(player, playerskill, floor);

    //level 4
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character trashsoldier = {"Trash Soldier", "Sword", 4, 40, 40, 4, 4, 5, 10, 1, 1, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashsoldier);
    player = levelUp(player, playerskill, trashsoldier);
    player = blessing(player, playerskill, floor);

    //level 5
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character trashsoldierL2 = {"Trash Soldier", "Spear", 5, 45, 45, 5, 5, 5, 10, 1, 1, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashsoldierL2);
    player = levelUp(player, playerskill, trashsoldierL2);
    player = blessing(player, playerskill, floor);

    //level 6
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character trashsoldierL3 = {"Trash Soldier", "Spear", 6, 50, 50, 5, 6, 6, 15, 2, 2, 0, 0, 0, 0};
    battleSimulation(player, playerskill, trashsoldierL3);
    player = levelUp(player, playerskill, trashsoldierL3);
    player = blessing(player, playerskill, floor);

    //level 7
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character ratmage = {"Rat Mage", "Reekburst", 7, 50, 50, 4, 7, 3, 15, 3, 3, 0, 0, 0, 0};
    battleSimulation(player, playerskill, ratmage);
    player = levelUp(player, playerskill, ratmage);
    player = blessing(player, playerskill, floor);

    //level 8
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character ratmageL3 = {"Rat Mage", "Reekburst", 8, 50, 50, 5, 8, 3, 15, 3, 3, 0, 0, 0, 0};
    battleSimulation(player, playerskill, ratmageL3);
    player = levelUp(player, playerskill, ratmageL3);
    player = blessing(player, playerskill, floor);

    //level 9
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character ratmageL4 = {"Rat Mage", "Reekburst", 9, 60, 60, 6, 9, 3, 20, 4, 4, 0, 0, 0, 0};
    battleSimulation(player, playerskill, ratmageL4);
    player = levelUp(player, playerskill, ratmageL4);
    player = blessing(player, playerskill, floor);

    //level 10
    cout << "----Floor " << floor << "----\n";
    floor++;
    Character ratking = {"Rat King", "Rat-tling", 10, 75, 75, 8, 15, 8, 30, 4, 4, 0, 0, 0, 0};
    battleSimulation(player, playerskill, ratking);
}

void gameload () {
    int rng, delay;

    for (int load = 0; load < 100;) {
        cout << "--LOADING--\n\n\n\n\n";
        rng = time(0);
        srand(rng);
        delay = 1 + rand() % 25;
        cout << load << " / 100";
        Sleep(500);
        load+= delay;
        system("cls");
    }

    cout << "--LOADING--\n\n\n\n\n";
    cout << "100 / 100";
    Sleep(1000);

    system("cls");
}

int damage(int atk, string wpn, int def, int lvl) {
    int dmg, rng, bonus;
    if (wpn == "Stick" || wpn == "Broomstick") {
        dmg = atk + 2;
    } else if (wpn == "Sword" || wpn == "Mop") {
        dmg = atk * 2;
    } else if (wpn == "Spear") {
        dmg = atk * 2 + 2;
    } else if (wpn == "Vacuum Cleaner") {
        cout << "The hero used the vacuum cleaner!\n";
        dmg = atk * 2 + lvl;
    } else if (wpn == "Reekburst") {
        dmg = atk * 2 + 5;
    } else if (wpn == "Rat-tling") {
        cout << "The Rat King used Rat-tling!\n";
        dmg = atk * 2 + lvl;
    } else {
        dmg = atk;
    }

    rng = time(0);
    srand(rng);
    bonus = rand() % lvl;
    return dmg + bonus - def;
}

void nextlvl (int lvl){
    string choice;
    cout << "Do you want to continue? (Y/N)";
    cin >> choice;

    if (choice == "Y" || choice == "y") {
        cout << "Loading enemy " << lvl << "...\n";
    } else if (choice == "N" || choice == "n") {
        cout << "Ending game...\n";
    } else {
        lvl--;
        nextlvl(lvl);
    }
}

int difficulty(Character &player, Skills&playerskill, Character &enemy){
if (playerskill.difficulty == "3" || playerskill.difficulty == "Hard" || playerskill.difficulty == "hard") {
    enemy.maxhp+=(player.lvl-1)*5;
    enemy.hp = enemy.maxhp;
    enemy.pow+=player.lvl;
    enemy.def+=player.lvl;
    enemy.spd+=player.lvl;
    enemy.rec+=(player.lvl-1)*5;
    enemy.maxmana++;
    enemy.mana = enemy.maxmana;

    player.maxpow = 15;
    player.maxdef = 15;
    player.maxspd = 15;

} else if (playerskill.difficulty == "2" || playerskill.difficulty == "Medium" || playerskill.difficulty == "medium") {
    enemy.pow+=player.lvl;
    enemy.def+=player.lvl;
    enemy.spd+=player.lvl;

    player.maxpow = 20;
    player.maxdef = 20;
    player.maxspd = 20;
} else if (playerskill.difficulty == "1" || playerskill.difficulty == "Easy" || playerskill.difficulty == "easy") {
    player.pow++;
    player.def++;

    player.maxpow = 25;
    player.maxdef = 25;
    player.maxspd = 25;
}
}

int battleSimulation(Character &player, Skills&playerskill, Character &enemy) {
bool battle = true;
int round = 0;
string choice;
cout << "\n\n" << player.name << " was challenged by " << enemy.name << "!\n";

difficulty(player, playerskill, enemy);

if (playerskill.mode == "BossRush") {
    player.hp = player.maxhp;
    player.mana = player.maxmana;
}

while (battle == true) {
    system("pause"); system("cls");
    round++;
    cout << "--Round " << round << "--\n\n";

    ascii(enemy);

    cout << enemy.name << "'s HP: " << enemy.hp << " / " << enemy.maxhp << " | MANA: " << enemy.mana << " / " << enemy.maxmana << " | LVL: " << enemy.lvl << "\n";
    cout << player.name << "'s HP: " << player.hp << " / " << player.maxhp << " | MANA: " << player.mana << " / " << player.maxmana << " | LVL: " << player.lvl << "\n";

    cout << "What do you want to do? \n";
    cout << "1. Attack\n2. Stats\n3. Heal\n";
    cout << player.name << ": ";
    cin >> choice;

    if (choice == "1") {
        if (playerskill.skill1 == "N/A" && playerskill.skill2 == "N/A" && playerskill.skill3 == "N/A") {
            attackSimulation(player, playerskill, enemy);
        } else {
            int num = 1;
            string choice;
            cout << "What would you like to do?\n";
            cout << num << ". Use your " << player.wpn << " to attack - COSTS NO MANA\n";
            if (playerskill.skill1 != "N/A") {
                cout << "2. Use your """ << playerskill.skill1 << """ skill - Makes the user instantly go last. Deals extra damage equal to damage taken (COSTS 1 MANA).\n";
            }
            if (playerskill.skill2 != "N/A") {
                cout << "3. Use your """ << playerskill.skill2 << """ skill - Deals damage ignoring the opponent's defense. Costs 1 mana.\n";
            }
            if (playerskill.skill3 != "N/A") {
                cout << "4. Use your """ << playerskill.skill3 << """ skill - Makes the user instantly go last. Deals twice the damage. Costs 2 mana.\n";
            }
            cout << "a. Go Back.\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "1") {
                attackSimulation(player, playerskill, enemy);
            } else if (choice == "2" || choice == "3" || choice == "4") {
                skillSimulation(player, playerskill, enemy, choice);
            } else if (choice == "a") {
                round--;
            }else {
                cout << "Not an action!\n";
                round--;
            }
        }

    } else if (choice == "2") {
        cout << "--------\n";
        cout << player.name << "'s stats\n";
        cout << "LVL: " << player.lvl << "\n";
        cout << "HP: " << player.hp << " / " << player.maxhp << "\n";
        cout << "MANA: " << player.mana << " / " << player.maxmana << "\n";
        cout << "WEAPON: " << player.wpn << "\n";
        cout << "ATK: " << player.pow << "\n";
        cout << "DEF: " << player.def << "\n";
        cout << "SPD: " << player.spd << "\n\n";
        cout << "--------\n";
        cout << player.name << "'s skills\n";
        cout << "Skill 1: " << playerskill.skill1 << "\n";
        cout << "Skill 2: " << playerskill.skill2 << "\n";
        cout << "Skill 3: " << playerskill.skill3 << "\n";


        cout << enemy.name << "'s HP: " << enemy.hp << " / " << enemy.maxhp << "\n";
        cout << enemy.name << "'s MANA: " << enemy.mana << " / " << enemy.maxmana << "\n";
        cout << enemy.name << " LVL: " << enemy.lvl << "\n";
        round--;

    } else if (choice == "3") {
        if (player.mana <= 0) {
            cout << "You have run out of mana, you cannot heal!\n";
            round--;
        } else {
            player.hp += player.rec;
            player.mana--;

            if (player.hp > player.maxhp) {
                cout << player.name << " healed back to max HP!\n";
                player.hp = player.maxhp;
            } else {
                cout << player.name << " healed " << player.rec << " damage!\n";
            }

            int dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 5;
            if (dmg < 1) {
                dmg = 1;
            }
            player.hp -= dmg - player.maxmana;

            cout << enemy.name << " dealt " << dmg << " damage!\n";

            if (player.hp > player.maxhp) {
                player.hp = player.maxhp;
            }
        }

    } else {
            cout << "Not an action!\n";
            round--;
        }

    if (enemy.maxmana > 0 && enemy.hp <= (enemy.maxhp / 2) && enemy.mana > 0 && enemy.rec > 0) {
        enemy.hp += enemy.rec;
        cout << enemy.name << " healed " << enemy.rec << " HP\n";
        enemy.mana--;

        if (enemy.hp > enemy.maxhp) {
            enemy.hp = enemy.maxhp;
        }
    } else if (enemy.hp <= (enemy.maxhp / 2)) {
        cout << "The " << enemy.name << " looks like its struggling to fight...\n";
    } else if (enemy.maxmana > 0 && enemy.mana < enemy.maxmana) {
        cout << "The " << enemy.name << " looks weakened...\n";
    } else if (enemy.maxmana > 0){
        cout << "The " << enemy.name << " looks raring to go...\n";
    }

    if (enemy.hp <= 0) {
        cout << enemy.name << " was slain\n";
        battle = false;
    }
}

system("pause");
return player.hp;
}

Character firstpart(Character &player, Skills &playerskill, string choice) {
    string diff;

    while (true) {
        if (choice == "1"){
        player.name = "Johnny";
        cout << "\n???: Enter difficulty:\n1. Easy\n2. Medium\n3. Hard\nEnter Difficulty: ";
        cin >> diff;
        } else {
        cout << "???: What is your name?: " << endl;
        cin >> player.name;
        cout << "\n???: Enter difficulty:\n1. Easy\n2. Medium\n3. Hard\nEnter Difficulty: ";
        cin >> diff;
        }

        if (diff == "1" || diff == "Easy" || diff == "easy") {
            cout << "Turning on easy mode...\n";
            player.maxhp = 35;
            player.hp = 35;
            playerskill.hpass = 3;
            break;
        } else if (diff == "2" || diff == "Medium" || diff == "medium") {
            cout << "Turning on medium mode...\n";
            playerskill.hpass = 2;
            break;
        } else if (diff == "3" || diff == "Hard" || diff == "hard") {
            cout << "Turning on hard mode...\n";
            player.spd = 3;
            playerskill.hpass = 1;
            break;
        } else {
            cout << "Invalid difficulty. Please enter a valid option.\n";
        }
    }

    system("pause");
    system("cls");

    playerskill.difficulty = diff;
    return player;
}

Character levelUp(Character &player, Skills&playerskill, Character &enemy) {
    int expgain = 0;
    int levelDifference = enemy.lvl - player.lvl;

    if (levelDifference >= 0) {
        expgain += (levelDifference * 25 + 50); // Normal calculation for higher or equal level
    } else if (levelDifference < -1 && levelDifference > -2 && playerskill.difficulty == "hard") {
        expgain += (levelDifference * 10 + 20); // Normal calculation for higher or equal level
    } else if (levelDifference < -1 && playerskill.difficulty != "hard") {
        expgain += (levelDifference * 10 + 20); // Normal calculation for higher or equal level
    } else {
        // Additional experience gain for lower-level player
        expgain += (levelDifference * 10 + 50);
    }

    player.exp += expgain;

    cout << player.name << " gained " << expgain << " EXP!\n\n";

    while (player.exp >= 100) {
        player.lvl++;
        player.exp -= 100;
        cout << player.name << " leveled up!\n";
        player.hp += 5;
        player.maxhp += 5;
        player.pow++;
        player.def++;
        player.spd++;
        player.rec += player.lvl;
        player.maxmana++;
        player.mana = player.maxmana;

        if (player.pow > player.maxpow) {
            cout << player.name << "'s ATK cannot be increased! \n";
            player.pow = player.maxpow;
        }
        if (player.def > player.maxdef) {
            cout << player.name << "'s DEF cannot be increased! \n";
            player.def = player.maxdef;
        }
        if (player.spd > player.maxspd) {
            cout << player.name << "'s SPD cannot be increased! \n";
            player.spd = player.maxspd;
        }

        if (playerskill.mode == "BossRush") {
            player.hp = player.maxhp;
        }

        if (playerskill.skill1 != "Reversal" && player.lvl >= 2) {
            cout << "Acquired the skill ""Reversal""\n";
            playerskill.skill1 = "Reversal";
        } else if (playerskill.skill2 != "Piercing Thrust" && player.lvl >= 5) {
            cout << "Acquired the skill ""Piercing Thrust""\n";
            playerskill.skill2 = "Piercing Thrust";
        } else if (playerskill.skill3 != "Heavy Impact" && player.lvl >= 8) {
            cout << "Acquired the skill ""Heavy Impact""\n";
            playerskill.skill3 = "Heavy Impact";
        }

        cout << "--------\n";
        cout << player.name << "'s stats\n";
        cout << "LVL: " << player.lvl << "\n";
        cout << "HP: " << player.hp << " / " << player.maxhp << "\n";
        cout << "MANA: " << player.mana << " / " << player.maxmana << "\n";
        cout << "WEAPON: " << player.wpn << "\n";
        cout << "ATK: " << player.pow << "\n";
        cout << "DEF: " << player.def << "\n";
        cout << "SPD: " << player.spd << "\n\n";
        system("pause");
    }

    return player;
}

Character blessing(Character &player, Skills &playerskill, int floor) {
    system("cls");
    string bless; bool proceed = false;

    while (proceed == false) {
            cout << R"(
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
--------------------------------=+++*****++==---------------------------------------------
----------------------------=+*****************=------------------------------------------
---------------------------***********+++===+***+-----------------------------------------
---------------------------******-.            =*=----------------------------------------
--------------------------=*****:               +=----------------------------------------
--------------------------=****=                :=----------------------------------------
---------------------------+**-                 .=----------------------------------------
---------------------------:=-                   -----------------------------------------
---------------------------:-:                  =-----------------------------------------
---------------------------+*-    .:-=====-::  :*-----------------------------------------
----------------------------**:   +*=-----=+*--**-----------------------------------------
----------------------------***=:.*+       .****+=----------------------------------------
-------------------------====+*****=..=*+:-+***+=====.::----------------------------------
--------------------:..==========************=======-    .:-------------------------------
-------------:::::.    .======== .+********=.-======.     : .-----------------------------
------------   . ..-:   .=======:  .=****+.  ======:     :.  .-=--------------------------
-----------:        .=.  .=======    =++=:  :======      =-*%@@@@@@#+---------------------
-----------          :=   :======:   ====:  ======.  .+#@@@@@@@@@@@@@@#-------------------
----------:           =:   :======.  ====- -=====. -#@@###*#@@@@@@@@@@@@+-----------------
----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------
---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------
---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------
---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------
--------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------
---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------
---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------
--------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------
--------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------
--------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+.  :@@@@@@@@@@@@@@*-------------------
--------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------
)" << '\n';
        cout << "Principal: Welcome, " << player.name << "...\n";
        cout << "Principal: For cleaning up trash in the school, I shall give you an incentive! Choose wisely...\n";
        cout << "1. Grant +1 to all main combat stats (ATK, DEF, SPD)\n";
        cout << "2. Increased HP, MANA and recovery\n";

        if (playerskill.mode == "BossRush") {
            if (player.wpn == "Broomstick") {
            cout << "3. Grant " << player.name << " a better cleaning tool.\n";
            } else if (player.wpn == "Mop" && player.wpn != "Vacuum Cleaner" && floor > 8) {
                cout << "3. Grant " << player.name << " the cleaner of legends.\n";
            } else {
                cout << "3. Massively increase Attack\n";
            }
        }

        cout << "Principal: Enter your choice, student...\n";
        cout << player.name << "'s choice: ";
        cin >> bless;

        cout << "Principal: Here, take this...\n";

        if (bless == "1") {
            cout << player.name << " feels stronger!\n";
            player.pow++;
            player.def++;
            player.spd++;

            if (player.pow > player.maxpow) {
                cout << player.name << "'s ATK cannot be increased! \n";
                player.pow = player.maxpow;
            }
            if (player.def > player.maxdef) {
                cout << player.name << "'s DEF cannot be increased! \n";
                player.def = player.maxdef;
            }
            if (player.spd > player.maxspd) {
                cout << player.name << "'s SPD cannot be increased! \n";
                player.spd = player.maxspd;
            }
            proceed = true;
        } else if (bless == "2") {
            cout << player.name << " feels sturdier!\n";
            player.maxhp+=5;
            player.hp = player.maxhp;
            player.maxmana++;
            player.mana = player.mana;
            player.rec+=5;
            proceed = true;
        } else if (bless == "3" && playerskill.mode == "BossRush") {
            if (player.wpn != "Mop") {
                cout << player.name << " obtained a mop.\n";
                cout << player.name << " felt a surge of strength!\n";
                player.pow++;
                player.spd++;
                player.def++;
                player.wpn = "Mop";

                if (player.pow > player.maxpow) {
                    cout << player.name << "'s ATK cannot be increased! \n";
                    player.pow = player.maxpow;
                }
                if (player.def > player.maxdef) {
                    cout << player.name << "'s DEF cannot be increased! \n";
                    player.def = player.maxdef;
                }
                if (player.spd > player.maxspd) {
                    cout << player.name << "'s SPD cannot be increased! \n";
                    player.spd = player.maxspd;
                }
            } else if (player.wpn == "Mop" && player.wpn != "Vacuum Cleaner" && floor > 8) {
                cout << player.name << " obtained the Clean-inator 9000.\n";
                player.wpn = "Vacuum Cleaner";
                cout << player.name << " feels the strength of the vacuum, and feels a surge of strength!\n";
                player.pow+=2;
                player.spd+=2;
                player.def+=2;

                if (player.pow > player.maxpow) {
                    cout << player.name << "'s ATK cannot be increased! \n";
                    player.pow = player.maxpow;
                }
                if (player.def > player.maxdef) {
                    cout << player.name << "'s DEF cannot be increased! \n";
                    player.def = player.maxdef;
                }
                if (player.spd > player.maxspd) {
                    cout << player.name << "'s SPD cannot be increased! \n";
                    player.spd = player.maxspd;
                }

            } else {
                cout << player.name << " feels more powerful!\n";
                player.pow+=2;
            }
            proceed = true;
        } else {
            cout << R"(
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
--------------------------------=+++*****++==---------------------------------------------
----------------------------=+*****************=------------------------------------------
---------------------------***********+++===+***+-----------------------------------------
---------------------------******-.            =*=----------------------------------------
--------------------------=*****:               +=----------------------------------------
--------------------------=****=                :=----------------------------------------
---------------------------+**-                 .=----------------------------------------
---------------------------:=-                   -----------------------------------------
---------------------------:-:                  =-----------------------------------------
---------------------------+*-    .:-=====-::  :*-----------------------------------------
----------------------------**:   +*=-----=+*--**-----------------------------------------
----------------------------***=:.*+       .****+=----------------------------------------
-------------------------====+*****=..=*+:-+***+=====.::----------------------------------
--------------------:..==========************=======-    .:-------------------------------
-------------:::::.    .======== .+********=.-======.     : .-----------------------------
------------   . ..-:   .=======:  .=****+.  ======:     :.  .-=--------------------------
-----------:        .=.  .=======    =++=:  :======      =-*%@@@@@@#+---------------------
-----------          :=   :======:   ====:  ======.  .+#@@@@@@@@@@@@@@#-------------------
----------:           =:   :======.  ====- -=====. -#@@###*#@@@@@@@@@@@@+-----------------
----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------
---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------
---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------
---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------
--------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------
---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------
---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------
--------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------
--------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------
--------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+.  :@@@@@@@@@@@@@@*-------------------
--------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------
)" << '\n';
            cout << "Principal: Wait, that answer does not seem right\n";
            system("cls");
        }
    }

    cout << "--------\n";
    cout << player.name << "'s stats\n";
    cout << "LVL: " << player.lvl << "\n";
    cout << "HP: " << player.hp << " / " << player.maxhp << "\n";
    cout << "MANA: " << player.mana << " / " << player.maxmana << "\n";
    cout << "WEAPON: " << player.wpn << "\n";
    cout << "ATK: " << player.pow << "\n";
    cout << "DEF: " << player.def << "\n";
    cout << "SPD: " << player.spd << "\n\n";

    return player;

}

void gameover () {
    string choice;

    cout << "???: You have lost the battle... Try better next time.\n";

    cout << "???: Would you like to try again? (Y/N)\n";
    cin >> choice;

    if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
        system("pause");
        system("cls");
        main();
    } else if (choice == "N" || choice == "n" || choice == "No" || choice == "no"){
        exit(0);
    } else {
        gameover();
    }

}

int attackSimulation(Character &player, Skills&playerskill, Character &enemy) {
if (player.spd >= enemy.spd) {
    // Combat logic for character attacking first
    int dmg = damage(player.pow, player.wpn, enemy.def, player.lvl);
    if (dmg < 1) {
        dmg = 1;
    }
    enemy.hp -= dmg;

    cout << player.name << " dealt " << dmg << " damage!\n";

    if (enemy.hp <= 0) {
        return 1;
    }

    dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
    if (dmg < 1) {
        dmg = 1;
    }
    player.hp -= dmg;

    cout << enemy.name << " dealt " << dmg << " damage!\n";

    if (player.hp <= 0) {
        cout << player.name << " was slain\n";
        gameover ();
    }

    } else {
        // Combat logic for monster attacking first
        // Similar to above, but switch the order of attacks
        int dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
        if (dmg < 1) {
            dmg = 1;
        }
        player.hp -= dmg;

        cout << enemy.name << " dealt " << dmg << " damage!\n";
        //cout << player.name << " has " << player.hp << " left\n";

        if (player.hp <= 0) {
            cout << player.name << " was slain\n";
            gameover ();
        } else {}

        dmg = damage(player.pow, player.wpn, enemy.def, player.lvl);
        if (dmg < 1) {
            dmg = 1;
        }
        enemy.hp -= dmg;

        cout << player.name << " dealt " << dmg << " damage!\n";

    }
}

int skillSimulation(Character &player, Skills&playerskill, Character &enemy, string choice) {
int dmg;
int rng = time(0);
srand(rng);
int bonus = rand() % player.lvl;

if (choice == "2" && playerskill.skill1 == "Reversal") {
    if (player.mana <= 0) {
        cout << "You have run out of mana, you cannot use ""Reversal""!\n";
        cout << "You have can't use skills, initiating attack!\n";
        attackSimulation(player, playerskill, enemy);
    } else {
        // Combat logic for monster attacking first
        // Similar to above, but switch the order of attacks
        cout << player.name << " is waiting for the opponent's move!\n";
        dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
        if (dmg < 1) {
            dmg = 1;
        }

        player.hp -= dmg;

        if (player.hp <= 0) {
            cout << player.name << " was slain\n";
            gameover ();
        }

        cout << enemy.name << " dealt " << dmg << " damage!\n";
        dmg = player.pow + (player.maxhp - player.hp) - enemy.def;
        if (dmg < 1) {
            dmg = 1;
        }
        enemy.hp -= dmg;

        cout << player.name << " dealt " << dmg << " damage!\n";

        if (enemy.hp <= 0) {
            return 1;
        }

        player.mana--;
    }
} else if (choice == "4" && playerskill.skill3 == "Heavy Impact") {
    if (player.mana <= 0) {
        cout << "You have run out of mana, you cannot use ""Heavy Impact""!\n";
        cout << "You have can't use skills, initiating attack!\n";
        attackSimulation(player, playerskill, enemy);
    } else {
        cout << player.name << " is charging ""Heavy Impact""!\n";
        // monster goes first due to "Heavy Thrust"

        dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
        if (dmg < 1) {
            dmg = 1;
        }
        player.hp -= dmg;

        cout << enemy.name << " dealt " << dmg << " damage!\n";

        if (player.hp <= 0) {
            cout << player.name << " was slain\n";
            gameover ();
        }

        dmg = damage(player.pow, player.wpn, enemy.def, player.lvl) * 2;
        if (dmg < 1) {
            dmg = 1;
        }
        enemy.hp -= dmg;

        cout << player.name << " dealt " << dmg << " damage!\n";

        if (enemy.hp <= 0) {
            return 1;
        }

        player.mana-=2;

    }

} else if (choice == "3" && playerskill.skill2 == "Piercing Thrust") {
    if (player.mana <= 0) {
        cout << "You have run out of mana, you cannot use ""Piercing Thrust""!\n";
        cout << "You have can't use skills, initiating attack!\n";
        attackSimulation(player, playerskill, enemy);
    } else {
        if (player.spd >= enemy.spd) {

            dmg = player.pow + player.lvl + bonus;
            if (dmg < 1) {
                dmg = 1;
            }
            enemy.hp -= dmg;

            cout << player.name << " dealt " << dmg << " damage!\n";

            if (enemy.hp <= 0) {
                return 1;
            }

            dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
            if (dmg < 1) {
                dmg = 1;
            }
            player.hp -= dmg;

            if (player.hp <= 0) {
                cout << player.name << " was slain\n";
                gameover ();
            }

            cout << enemy.name << " dealt " << dmg << " damage!\n";

        } else {
            // Combat logic for monster attacking first
            // Similar to above, but switch the order of attacks
            dmg = damage(enemy.pow, enemy.wpn, player.def, enemy.lvl) - 1;
            if (dmg < 1) {
                dmg = 1;
            }
            player.hp -= dmg;

            cout << enemy.name << " dealt " << dmg << " damage!\n";

            if (player.hp <= 0) {
                cout << player.name << " was slain\n";
                gameover ();
            }


            dmg = player.pow + player.lvl + bonus;
            if (dmg < 1) {
                dmg = 1;
            }
            enemy.hp -= dmg;

            cout << player.name << " dealt " << dmg << " damage!\n";

            if (enemy.hp <= 0) {
                return 1;
            }
        }

    player.mana--;

    }
} else {
    cout << "You have no skills, initiating attack!\n";
    attackSimulation(player, playerskill, enemy);
}
}

Character mainhub(Character &player, Skills &playerskill){
    system("cls");
    string choice;
    cout << "Johnny is at the school entrance, what do you want him to do?\n";
    cout << "1. Head to the classroom (Recommended level - 1)\n2. Head to the field (Recommended level - 3)\n3. Head to the bathroom (Recommended level - 5)\n4. Head to the clinic (Heal passes left: " << playerskill.hpass << ") \n";
    cout << "Player: ";
    cin >> choice;

    if (choice == "1") {
        cout << "Heading to the classroom...\n";
        maincroom(player, playerskill);
    } else if (choice == "2") {
        cout << "Heading to the field...\n";
        mainfield(player, playerskill);
    } else if (choice == "3") {
        cout << "Heading to the bathroom...\n";
        mainbroom(player, playerskill);
    } else if (choice == "4") {
        cout << R"(
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
--------------------------------------------====------------------------------------------
-------------------------------------#@@@@@@@@@@@#+---------------------------------------
------------------------------------=@@@@@@@@@@@@@@+--------------------------------------
----------------------------------=+##############%*=-------------------------------------
---------------------------------=###################*------------------------------------
---------------------------------#####################=-----------------------------------
---------------------------------#####################=-----------------------------------
---------------------------------#####################+-----------------------------------
------------------------------=+####%%%%%%%%%%%%%%%##=*#+---------------------------------
----------------------------+*#*=+#%%%%%%%%%%%%%%%%#*--=*#+-------------------------------
--------------------------+##*=--=#%%%%%%%%%%%%%%%##+----*#*------------------------------
-------------------------*##=-----#%%%%%%%%%%%%%%%%*------+#*-----------------------------
------------------------+##=-------#%%%%%%%%%%%%%%#--------*#*----------------------------
------------------------##*---------*%%%%%%%%%%%%#=--------=##----------------------------
-----------------------+##=---------*+=+*%%%%%*=-*+=-------=##=---------------------------
-----------------------+##+--------=#+--=%%%%%*---+*#*+==-=*#*----------------------------
------------------------*##*+++++*###%%%%%%%%%%%%##@#######*+-----------------------------
--------------------------+*######%@@%%%%%%%%%%%%%@@@%%%%%+-------------------------------
---------------------------=%%%%%%@@@%%%%%%%%%%%%%@@@%%%%%%+------------------------------
---------------------------%%%%%%%@@@%%%%%%%%%%%%%@@@%%%%%%%=-----------------------------
--------------------------#%%%%%%%@@@%%%%%%%%%%%%%@@%%%%%%%%+-----------------------------
--------------------------#%%%%%%%@@@@@@@@@@@@@@@@@@%%%%%%%+------------------------------
---------------------------#%%%%%%@@@@@@@@@@@@@@@@@@%%%%%%*-------------------------------
----------------------------#%%%%%%@@@@@@@@@@@@@@@@%%%%%%#--------------------------------
-----------------------------#%%%%%%@@@@@@@@@@@@@@%%%%%%%+--------------------------------
------------------------------@%%%%%%@@@@@@@@@@@@%%%%%@@@@--------------------------------
-----------------------------=@@%%%%%%@@@@@@@@@@%%%%%%@@@@--------------------------------
-----------------------------=@@@%%%%%%@@@@@@@@%%%%%%@@@@%--------------------------------
-----------------------------+@@@@%%%%%%@@@@@@%%%%%@@@@@@%--------------------------------
-----------------------------%@@@@@%%%%%%@@@@%%%%%@@@@@@@@--------------------------------
----------------------------=@@@@@@@%%%%%%@@%%%%%@@@@@@@@@=-------------------------------
)" << '\n;';
        cout << "th Nurse Joy: Welcome to our school's clinic!\n";
        Sleep(1000);
        cout << "2619th Nurse Joy: We heal students back to perfect health in exchange for a heal pass!\n";
        Sleep(1000);
        cout << "2619th Nurse Joy: Shall we heal you? (Y/N) (Heal passes left: " << playerskill.hpass << ") \n";
        Sleep(1000);
        cout << player.name << ": ";
        cin >> choice;

        if ((choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") && playerskill.hpass > 0) {
            cout << "You went to get patched up...\n";
            player.hp = player.maxhp;
            player.mana = player.maxmana;
            playerskill.hpass--;
            cout << "2619th Nurse Joy: Thank you! You are now fighting fit!\n";
            Sleep(1000);
            cout << "2619th Nurse Joy: We hope to see you again!\n";
            Sleep(1000);
        } else if (playerskill.hpass <= 0) {
            cout << "2619th Nurse Joy: It seems you do not have a heal pass...\n";
            Sleep(1000);
            cout << "2619th Nurse Joy: Come back when you have one!\n";
            Sleep(1000);
            cout << "2619th Nurse Joy: We hope to see you again!\n";
            Sleep(1000);
        } else {
            cout << "Strong men don't need rest anyway...\n";
            cout << "2619th Nurse Joy: We hope to see you again!\n";
            Sleep(1000);
        }

        system("pause");
        system("cls");
        mainhub(player, playerskill);
    } else {
        cout << "Incorrect input, try again...\n";
        system("pause");
        system("cls");
        mainhub(player, playerskill);
    }
}

Character maincroom(Character &player, Skills &playerskill){
    bool step1 = true, step2 = true, step3 = true, explore = true, mop = false;
    string choice;
    int step = 0;

    while (explore) {
        system("cls");
        cout << R"(
------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------:::
-------:::------------------------------------------------------::::::::::::..............
-----.     :------------------------------::::::::::::....................................
=====---=-:---------------:::::...........................................................
================---------:................................................................
================---------:................................................................
================---------:................................................................
================---------:................................................................
=================--------:................................................................
================---------:................................................................
=================--------:................................................................
=================- .-----:................................................................
================--. :----:................................................................
============.-===-: .----:................................................................
==========+*:=%%%=:  ----:................................................................
    .*#%%@@%#*+=---  :------:::::::.......................................................
:=+#%%#*+=--------==:=+==-------------.  .::::::..........................................
#*+=---------+*#%@##+@@@@@@%#---------. .-------------::::::..............................
-------==-..  .-=%@@@@@@@@@@+--------: .-------------------------.        ................
-=+*#%@@@@@@#*#*  +@@@@@@@@@+---------: :-----------------------:         ----:.  ..:.....
@@@@@@@@@@@@@@@@@- *@@@@@@@@+---------: :-----------------------.        -----      ------
@@@@@@@@@@@@@@@@@*.%@@@@@@@@+---------: -----------==-...======--------------:      ------
@@@@@@@@@@@@@@@@@=-@@@@@@@@@+---------. ---------====::-======-------------==      .------
@@@@@@@@@@@@@@@@@#-@@@@@@@@@+---------. -------=========--====------------====-----====---
@@@@@@@@@@@@@@@@@@.%@@@@@@@@+----------:--------=++=========+------------==============---
@@@@@@@@@@@@@@@@@@.%@@@@@%*=--::-----------------##--#=-#*=+#-----------=============+----
@@@@@@@@@@@@@@@@@%.@@@@#+------:-:---------------##--%=-@#-+*-----------==+==========+----
@@@@@@@@@@@@@@@@@%%@%*=---------:.-----=--=======##--*--@#-+*------------=@+#=---=+*+=----
@@@@@@@@@@@@@@@@@@#+-----------:::---===---:-=======+---@#-++------------=@+#=----*@%-----
@@@@@@@@@@@@@@@%*=----:..:--------=================+=---@#----------======-:++----*@%-----
@@@@@@@@@@@@%#+----:::..:--------============-.-==+=---=@#---------======:  :=====+%%-----
@@@@@@@@@@%+-------:..:----------==++=========-====----=@*--------========   -=====#*-----
)" << '\n';
        cout << "You are at the dirtiest classroom you've ever seen, it reeks here, what do you want to do?\n";
        cout << "1. Go forward\n2. Go backward\n3. Go back to the main entrance\n";
        cout << player.name << ": ";
        cin >> choice;

        if (choice == "1") {
            cout << player.name << " went forward.\n";
            step++;
        } else if (choice == "2") {
            cout << player.name << " player went backward.\n";
            step--;
        } else if (choice == "3") {
            cout << player.name << " went back to the entrance.\n";
            mainhub(player, playerskill);
        } else {
            cout << "Incorrect input, try again...\n";
        }

        if (step == 1 && step1 == true) {
            cout << R"(
-------::..:----------------------------------------------------------------::::::::::::..
-----:      :-----------------------------------------::::::::::::........................
=====:::-:...-------------------:::::::::::...............................................
==================------------............................................................
===================-----------............................................................
===================-----------............................................................
===================-----------............................................................
===================-----------............................................................
===================-----------............................................................
===================-----------............................................................
===================-----------............................................................
===================--:--------............................................................
===================-- .-------............................................................
===================--  :------............................................................
==============:====--. .------............................................................
=============- =+**=-:  ------............................................................
-==-=====+**#*-%@@%*-:  :-----............................................................
    .#%%@@@@%#*+=-----  .-----------:::::::....  .........................................
-+*%@@%#*+=------------::==------------------.   .:::::...................................
%#*+=-----------=+*#%##=#@@@@%%##*-----------.  :------------:::::::......................
---------:... :-+#%@@%@@@@@@@@@@@*----------.  :--------------------------::::         ...
----=+*#%#*++:. .. :*@@@@@@@@@@@@+-----------. .-----------------------------:           :
*##%@@@@@@@@@@@@@%-: =%@@@@@@@@@@+-----------: :-----------------------------           :-
@@@@@@@@@@@@@@@@@@@%  *@@@@@@@@@@+-----------: .----------------=-----------:   .      :--
@@@@@@@@@@@@@@@@@@@@--%@@@@@@@@@@+-----------: :-------------==:..  =======---------------
@@@@@@@@@@@@@@@@@@@% +@@@@@@@@@@@+-----------. :-----------====:::-========---------------
@@@@@@@@@@@@@@@@@@@@.+@@@@@@@@@@@+-----------. :---------=======-==:-=====---------------=
@@@@@@@@@@@@@@@@@@@@#.@@@@@@@@@@@+-----------. :--------=================---------------==
@@@@@@@@@@@@@@@@@@@@% @@@@@@@@@@%=------------------------+#+==+=======+=--------------===
@@@@@@@@@@@@@@@@@@@@# @@@@@@@@%+----::--------------------+@+--%*-+#*==%=-------------====
@@@@@@@@@@@@@@@@@@@@+:@@@@@%*=------::--------------------*@+--%*-+@%--%=-------------====
@@@@@@@@@@@@@@@@@@@@*#@@@#+------------.--------=======---*@=--%*-+@#--@=---------------#%
@@@@@@@@@@@@@@@@@@@@@@%*=-------------:.-----===.:-:-=====++===---+@#--@=---------------#@
)" << '\n';
            Sleep(800);
            cout << "You inch closer and see an item by the corner.";
            Character trashman = {"Trashman", "Sword", 1, 30, 30, 2, 0, 2, 5, 0, 0, 0, 0, 0, 0};
            battleSimulation(player, playerskill, trashman);
            player = levelUp(player, playerskill, trashman);
            player = incentive(player, trashman);
            step1 = false;

        } else if (step == 2 && step2 == true) {
            cout << R"(
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================-------------:....................................................
========================--:.---------:....................................................
========================--. .--------:....................................................
========================--:  :-------:....................................................
=================-:=====--:  .-------:....................................................
=================: -==++---   -------:....................................................
================+: +%%@@%--.  :------:....................................................
.:::::-==+**#%%@@%#@%#*+=--.  .------::::::...............................................
      -%@@@@@@%%#*+=-------:   -----------------:::::::...    ............................
.=+*%@@@%%#*+=--------------:::==-----------------------.    .::::::......................
@@@%#*+=--------------=+*#%%*=*@@@@%%##**+--------------.   :-------------:::::::.........
+=-------------:::=+#@@@@@%*%*%@@@@@@@@@@%=------------:  .:---------------------------:::
----------=-:.       .==#@@@@@@@@@@@@@@@@*-------------.  :-------------------------------
-----=+*#%@@@@%##=----:  :#@@@@@@@@@@@@@@*--------------:  -------------------------------
+*#%@@@@@@@@@@@@@@@@@@#-:  #@@@@@@@@@@@@@*--------------:  -------------------------------
@@@@@@@@@@@@@@@@@@@@@@@@%. .%@@@@@@@@@@@@*--------------:  -------------------------------
@@@@@@@@@@@@@@@@@@@@@@@@@* -%@@@@@@@@@@@@*--------------:  ------------------=-.....======
@@@@@@@@@@@@@@@@@@@@@@@@@= #@@@@@@@@@@@@@*--------------.  ---------------=====---::======
@@@@@@@@@@@@@@@@@@@@@@@@@.:@@@@@@@@@@@@@@*--------------. .-------------======: ..========
@@@@@@@@@@@@@@@@@@@@@@@@@=.@@@@@@@@@@@@@@*--------------. .-----------=============::=====
@@@@@@@@@@@@@@@@@@@@@@@@@%:+@@@@@@@@@@@@@*--------------. .----------=====================
@@@@@@@@@@@@@@@@@@@@@@@@@@--@@@@@@@@@@@@@*---------------:------------==+*+============+==
@@@@@@@@@@@@@@@@@@@@@@@@@@:-@@@@@@@@@@@%*-------------------------------*@#---*#==+++===#+
@@@@@@@@@@@@@@@@@@@@@@@@@@:=@@@@@@@@%*=-----: .-------------------------*@#---#@--*@@=-=@+
)" << '\n';
            Sleep(800);
            cout << "The item becomes a bit clearer to see, it looks like a stick.";
            Character ratmage = {"Rat Mage", "Reekburst", 2, 30, 30, 1, 1, 2, 5, 1, 1, 0, 0, 0, 0};
            battleSimulation(player, playerskill, ratmage);
            player = levelUp(player, playerskill, ratmage);
            player = incentive(player, ratmage);
            step2 = false;

        } else if (step == 3 && step3 == true){
            if (mop == false) {
                cout << R"(
----------------==============------------------------------------------------------------
---------------=================----------------------------------------------------------
--------------====================--------------------------------------------------------
--------------=========+===========-------------------------------------------------------
--------------========#%#============-----------------------------------------------------
---------------========%%%+===========----------------------------------------------------
---------------=========%%%*===========---------------------------------------------------
----------------=========%%%#===========--------------------------------------------------
-----------------=========%%%%+==========-------------------------------------------------
------------------=========#%%%+==========------------------------------------------------
-------------------=========#%%%*=========------------------------------------------------
--------------------=========#%%%#=========-----------------------------------------------
---------------------=========*%%%#=========----------------------------------------------
----------------------=========*%%%%+========---------------------------------------------
-----------------------=========+%%%%+==========------------------------------------------
-----------------------==========+%%%%*=============--------------------------------------
------------------------==========+%%%%*=================---------------------------------
-------------------------===========%%%%#===================------------------------------
--------------------------===========#%%%%====================----------------------------
--------------------------============#%%%%+====+**=============--------------------------
---------------------------============*%%%%**#%%@@##*============------------------------
---------------------------=============*%%%%@@@@@@@@@@@@%%#=======-----------------------
---------------------------==========+*#%@@@@@@@@@@@@@@@@@@@@#======----------------------
---------------------------=========#%@@@@@@@@@@@@@@@@@@@@@@@@%*=====---------------------
---------------------------========+%@@@@@@@@@@@@@@@@@@@@@@@+*%@@@*==---------------------
---------------------------========#@@@@@@@@@@@@@@@@@@@@@@@@#+==*#+===--------------------
---------------------------========%@@#@@@@@@@@@@@@@@@@@@@@@@@#+======--------------------
---------------------------=======+@@**@@@@@@@@@@@@@@@@@@@@%#%%%+====---------------------
----------------------------======#@#==%@@@@@@@@@@@@@@@@@@@#=========---------------------
----------------------------=====+#@@==%@@#@@@@@@@@@@@@@#*#+========----------------------
-----------------------------======*+==##==#@@@@@@%%@@@#===========-----------------------
------------------------------==============####*+==**+===========------------------------
-------------------------------=================================--------------------------
)" << '\n';
                cout << "After inspecting further... you found a mop!\n";
                mop = true;
            } else if (mop == true) {
                cout << player.name << ": The mop is still lying there...";
            }

            cout << "Would you like it equipped? (Y/N)\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << player.name << ": Hell yeah!\n";
                cout << player.name << " obtained a mop!\n";
                player.wpn = "Mop";
                step3 = false;
            } else {
                cout << "Strong men don't need a mop to clean anyway...\n";
            }

        } else if (step > 3 || step < 0) {
            cout << player.name << ": Can't go further...\n";
            if (step > 3) {
                step--;
            } else if (step < 0) {
                cout << player.name << " went back to the main entrance\n";
                mainhub(player, playerskill);
            }

        } else {
            cout << player.name << ": This place is empty...\n";
        }

        system("pause");
    }
}

Character mainfield(Character &player, Skills &playerskill) {
    bool step1 = true, step2 = true, step3 = true, step4 = true, step5 = true, explore = true, vacuum = false;;
    string choice;
    int step = 0, boredom = 2;;

    while (explore) {
        system("cls");
        cout << R"(
..........................................................................................
::.................................................................................::..:..
:..-::::-:::....................................................................:..::..::.
-::-....:..-:::-::::............................................................-..::..::.
-.::...::..-.::::.:..:....:...............................................:::...-..::...-.
-.::...:...-..-.-.-..:.:..:.::.:.::.:.............:::::::::....::::::-:-::..:...=..:-:::=:
-.-....-...-..-.-.-..:.:.:-:--:---::-:-------=-----=----=====-:-:-.-.-.-.-::-:..=...-...-.
=:=::..=:::=.:-:=.-..-.-.-:-=-:=-=:==-==+++==---=-:---::::-----+--:-:-:-.-::-:..-...=...-.
=:-:...=..:=..=:=:-..-.=.-:+++++=++==::::-=+++****#******++==-::-==+=+++-+==+-::=-::=..:=:
=:-:...=...=.:=-+*+-=+++-=+===-:::-=+++************************+=-::-=+****#==::-:..=..:=.
=:=::::=-::=::=+****+=-:....:-=+**********************************+=-:.:-+***++++=-==:::=:
=.=:..:++==*++=+=::.....:-=+*****************************************+-:..:-=+##**=-+-:-=:
=.=::::*++=-:........:-=+*************************%#*******************++:.....-++-:=-::=-
+==:==--....... ...:-+***************************#%#**********************=-......-+*+=+++
**=-:......    .::-=**************************************###*****+********+=.......:=***#
..........  ..:-=+***********************+++*********************************:........:-+#
.............-++********++***************************************************+....  .....-
..........:-++******+==+******************************************************-....  .....
...  .....-+++*******+********************************************************=:....  ....
.   ......-+******++*******************************##********##%%%%%%%#*******+:..........
   .....:=+*************************************************%%#%%%%%%%%#******+-..........
  .....-+***************************************************###+#%%%%##*******=-:.........
 .......=*****************##***********************************+*************+-:.....  ...
 .......-********************************************************************-:......  ...
........=*******************************#%##****+=+************************+-:.......  ...
........-+*********#%#*******************%%%******==***********************=:.......  ....
.......:-+***********************###***#%%%#******+**********************+-:........  ....
........-=+**********************####%%%%%%%#**************************++-.........  .....
.........:-=*******************#####%%%%%%%%%#**********************+==-...........  .....
  ........:-=+*****************######%%%%%%%%%#*******************+=-:....................
   .........:-==+***************#########%%%%##****************+=-:.......................
.   ............:-==++************************************++=-:...........................
..   ...............::-====+++++*******++++++++====-----:::....................  .........
)" << '\n';
        cout << "You are at what used to be the green football field, feels like a dump here, what do you want to do?\n";
        cout << "1. Go forward\n2. Go backward\n3. Go back to the main entrance\n";
        cout << player.name << ": ";
        cin >> choice;

        if (choice == "1") {
            cout << player.name << " went forward.\n";
            step++;
        } else if (choice == "2" && step > 0) {
            cout << player.name << " went backward.\n";
            step--;
        } else if (choice == "3") {
            cout << player.name << " went back to the entrance.\n";
            mainhub(player, playerskill);
        } else {
            cout << "Incorrect input, try again...\n";
            system("cls");
            mainfield(player, playerskill);
        }

        if (step == 1 && step1 == true) {
            cout << R"(
..........................................................................................
:::::.................................................................................:...
......-::.:::..-...:............................................................:-::::-...
..:...-.:.-.-..-.:-:..-...........................:::::::::......::..-:=::--::=:.:....-...
.:-:::=:-:=.-.::..-.::+:::-::-::::::--::..-:-:=:=---=:-+:--:::.:.:=::-.-..:...=..-...:=:::
..-..:-.-.=:=:==+-=::-+:::=--=-=:---==-===+=+-+-==--=--==++++=--::+::-:-::-:::=::=:::.--..
..=..:-.-:=:=.+:-:=::==---===+***+===-----==::-::::..::::---==-=-=+:-=:--:--::=:.=....:=..
:-=::--:======+--=+=++++=-=-:--:-=-=--====+==++++++==++==::::::::-++==-==:--::=::=-:---+::
.--..=--+++*****++*++---:.:::-=-++**********###**********+++++-::::::-=+++++*+**-+*++**+::
=+=--+==++***+=-:.:::===++++************************************+==-:::::-++********##==-:
**---=+=::.:..:--=+++***********************************************++=::...:-=++**##*+=+-
-::.......:-==+*******************************************************+===-:...::=*####**+
......::-=+***************************************************************+=:......-=+***#
..:--=++*******************************************************************++--::.....:-=*
-==+*****************************************%#******************************+*++-........
+******************************************#%%%#********************************++-:......
*******************************************####************************************=--....
*********************************************************#####********++*************+=-..
**********************************************************####***********************++=..
*******************************==++****************************************************=..
*****++**************************=****+*************************************************=:
*++++++*********************************************************************************+:
-=+**************************************************************************************=
+***************************************************************************************+=
*****************************************************************************************+
**********************************************####**************##%%%#%%%%%%#*************
*************************************************************#%%%%%%%%%%%%%%%%***********+
************************************************************%%####%%%%%%%%%%%%#**********+
************************************************************#%%%%#*#%%%%%%%%%##**********+
********##*****************************************************#*==#########************+=
******###********************************************************+++#******************++-
***************************************************************************************+-:
***************************************************************************************=::
)" << '\n';
            Sleep(800);
            cout << "Something starts moving within the pile of trash in front of you." << endl;
            Sleep(800);
            cout << "A Trashman leaps forth!";
            Character trashman3 = {"Trashman", "Sword", 3, 30, 30, 4, 6, 5, 10, 1, 1, 0, 0, 0, 0};
            battleSimulation(player, playerskill, trashman3);
            player = levelUp(player, playerskill, trashman3);
            player = incentive(player, trashman3);
            step1 = false;
        } else if (step == 2 && step2 == true) {
            cout << R"(
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
....................................................................::.......-....:.::-=--
...:=.....:..................................-:::::::..-...........:-:...=::-+----=-::.=..
::-=+--:::=...:.........:.::.:...-.:-=--=-=--=--+-::*=:=::-..:..:...-=--:=:..=....-....+..
...+-...::+--==--=---=--=-=-:-:-:=::=--==-=--=--+---+=-=-=+===::-::.:=:..=...=....=....+..
---*-----=+--=+--=---=:-=-+--==-=++=+--+=-=-=---+---+==+=+*+++=-=-::-+-::=:::=-::-=::::+::
::=+=----=====*****++====-==-=---+++-::-:.:::::::::::::=====++--=----+-:-+:::=-::-=....+..
-=++-----+===++++++++=-=-:::----:-::::--------:...::::......:::-====++-::+:..--..-+---:+-:
++++++=--=--:::::.:---==-===++++++++++++++++**+++++**+==-:::::...:..:=++++===+=-::+-:-:=-.
**+===-....:::---:=++++**************%%#***************+++++=+=-:......:-=+++++=+=*++++**+
-:..::::::-====++++******************###***********************++==--::::.::-=++**********
:-===+++++++**************************************+****************+++--:::::..:-+=*******
++*********************************************************************+++=--::....::=++*+
***************************************************************************+=-::::.....:=+
***************************************************************************++==+=-:::.....
**********##*********************************************************************==-:.....
****************************************************+*****************************+=-::::.
**************************************#********************************************++===::
*************************************#%#*********************************************+++==
************************************#%%%#*************************************************
**********************************#%%%%%%#************************************************
***********************************#%%%%#*************************************************
**********************************************************####*************=+=************
*******************************************************########************++*************
*********************************************************######***************************
*****************++++*++******************************************************************
)" << '\n';
            cout << "Continuing further, you pass by a bench, would you like to take a rest? (Y/N)\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << "You took a short rest\n";
                player.hp+=20;
                player.mana = player.maxmana;

                if (player.hp > player.maxhp) {
                    player.hp = player.maxhp;
                }

                boredom--;

            } else if ((choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") && boredom <= 0) {
                cout << "You already felt the boredom from resting, you do not want to rest anymore...\n";
                step2 = false;
            } else {
                cout << "Strong men don't need rest anyway...\n";
            }

        } else if (step == 3 && step3 == true){
            cout << R"(
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
....................................................................::.......-....:.::-=--
...:=.....:..................................-:::::::..-...........:-:...=::-+----=-::.=..
::-=+--:::=...:.........:.::.:...-.:-=--=-=--=--+-::*=:=::-..:..:...-=--:=:..=....-....+..
...+-...::+--==--=---=--=-=-:-:-:=::=--==-=--=--+---+=-=-=+===::-::.:=:..=...=....=....+..
---*-----=+--=+--=---=:-=-+--==-=++=+--+=-=-=---+---+==+=+*+++=-=-::-+-::=:::=-::-=::::+::
::=+=----=====*****++====-==-=---+++-::-:.:::::::::::::=====++--=----+-:-+:::=-::-=....+..
-=++-----+===++++++++=-=-:::----:-::::--------:...::::......:::-====++-::+:..--..-+---:+-:
++++++=--=--:::::.:---==-===++++++++++++++++**+++++**+==-:::::...:..:=++++===+=-::+-:-:=-.
**+===-....:::---:=++++**************%%#***************+++++=+=-:......:-=+++++=+=*++++**+
-:..::::::-====++++******************###***********************++==--::::.::-=++**********
:-===+++++++**************************************+****************+++--:::::..:-+=*******
++*********************************************************************+++=--::....::=++*+
***************************************************************************+=-::::.....:=+
***************************************************************************++==+=-:::.....
**********##*********************************************************************==-:.....
****************************************************+*****************************+=-::::.
**************************************#********************************************++===::
*************************************#%#*********************************************+++==
************************************#%%%#*************************************************
**********************************#%%%%%%#************************************************
***********************************#%%%%#*************************************************
**********************************************************####*************=+=************
*******************************************************########************++*************
*********************************************************######***************************
*****************++++*++******************************************************************
)" << '\n';
            Sleep(800);
            cout << "You seem to see a beam of light emanating from a pile of trash." << endl;
            Sleep(800);
            cout << "A Trashman jumps out!";
            Character trashman4 = {"Trashman", "Spear", 3, 40, 40, 5, 7, 5, 15, 1, 1, 0, 0, 0, 0};
            battleSimulation(player, playerskill, trashman4);
            player = levelUp(player, playerskill, trashman4);
            player = incentive(player, trashman4);
            step3 = false;

        } else if (step == 5 && step5 == true){
            cout << R"(
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
..........................................................................................
.................................................-....................:-..................
................................:.....:..........+.:....-:......::....:+....:.............
........................=.......+:::--+=-===+++++*++++++*+=====+**+---=+-:::+::...........
.....+....:=::..:-......=:.:====+-----+=::::*...-+..:::-*=:..:.-*#-.:.-+....+.....--......
-----+=====*-:..:+...:..=:.....=-....:*:...:*::.-+:::::-*=:::.:.+*=:::=*::.:+:.:::+-......
-----+::::=+:.:.-+::---:+=:.:::+=::--=*=-===*==-++======*======-++====+*====*=====+=--::.:
:::::+-==-++=-=-=*+++==-++=++++*+====+*=====*===*+=====+*+======++=-+-=*-==+*+++++*==---:-
-----*=---*=----+*----=-*+==+=++-=---++-::-=+::-+-:::::=*-:::---++====+*+=+******+*++-:::-
-::--*---=*---=-=*:-==+=*=++++*=:-:::=+-::::-::-==--:---==---=::=+=---=*++++*+++++*+====-=
==-==*--:-==+=--=+-=---=*==+++=-:::-----:..:::::::...:::::::::::--:::-==++====-=++++-:--:-
+++++=+=---:-:.:--:-:---=-==--:::.::::::::::::::::...................:::-::---=++++*+=+---
=--=+=--::::.-::---::=::-::.:.::.:.-:-:-----=----=-:........:::::.::............::::::----
:--:-:::-::::-=-=+-===-====--:---==+==========+=+++=-=--:::--=-=-:=::.:.................:-
-===--:-=-=-==++=+++===+++++++=+++=++++++++++++++**++++++++++****+====-::-:-:::::-.:....:.
=+++==+++++=++*++*+*+++++*********************************************+==-----=---:-:::::.
++**++++***++*******************#%%%#*********************************=+===+++++=-=++--:::
********************************%%%%%%#**************************************++++++**++-:-
********************************%%+%%##***********************************************+++=
*****************************************************************************************+
****************************#******************************=+++***************************
******************************************************************************************
******************************************************************************************
******************************************************************************************
******************************************************************************************
)" << '\n';
            Sleep(800);
            cout << "The light was not caused by the Trashman... No, it couldn't possibly be..." << endl;
            Sleep(800);
            cout << "Your thoughts halt as a Trashsoldier jumps out!";
            Character trashsoldier = {"Trash Soldier", "Sword", 4, 45, 45, 6, 7, 5, 10, 1, 1, 0, 0, 0, 0};
            battleSimulation(player, playerskill, trashsoldier);
            player = levelUp(player, playerskill, trashsoldier);
            player = incentive(player, trashsoldier);
            step5 = false;

            cout << "You find the source of the light, it is a miracle that something this pure could be among the gunk in the field.";
            Sleep(600); ".";
            Sleep(800); ".";
            Sleep(1000);
            cout << endl << R"(
..........................................................................................
..........................................................................................
.............................................              ...............................
..........................................   .--.                .........................
.......................................     :*===:                    ....................
......................................      *@..==.                      .................
....................................        %@  -==                        ...............
...................................        .@%  .==.                        ..............
..................................         =@*   ==-......                   .............
.................................          %@=  .=======--===-:.              ............
.................................         .@@:  ========.::======-.            ...........
................................          +@@  -===================-            ..........
..............................            @@# -=========:---========-            .........
.............................            -@@*============:-==========.            ........
...........................              *@@+===========-:-===========             .......
.........................               .@@@=============:============-            .......
.......................               .-*@@%============--:============.            ......
......................              .===%@@*============--=:===========-            ......
....................              .=====@@@+============--:-============             .....
...................              -=====*@@@==============.-=============.            .....
..................              -======#@@#=============--:=============:            .....
................               -=======@@@*==============-:-============-             ....
..............                -=======+@@@================:=============-             ....
............                 .========#@@%===============--:-===========-             ....
..........                   -========@@@*===============.::-===========-             ....
........                     ========*@@@================-:-============-             ....
.......                      ========%@@#================ ..============-            .....
.......                .=-=+*#%%@@@@@@@@@@@@@@@%%%%#**++=-=-============-            .....
......             .=*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+==============.           ......
.......           -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.    -=========:         ........
........          %@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.      -========         .........
.........              .........                                .:----:        ...........
...........                                                                  .............
)" << '\n';
            Sleep(800);
            cout << "After inspecting, you cannot believe your eyes! You found the Clean-inator 9000, the cleaner of legends!\n";
            cout << "Would you like it equipped? (Y/N)\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << player.name << ": Hell yeah!\n";
                cout << player.name << " obtained the Clean-inator 9000!\n";
                player.wpn = "Vacuum Cleaner";
                vacuum = false;
            } else {
                cout << "You chose to reject the easy way...\n";
                vacuum = true;
            }

        } else if (step == 5 && step5 == false && vacuum == true){

            cout << player.name << ": The Clean-inator 9000 is still lying there...";
            cout << "Would you like it equipped? (Y/N)\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << R"(
..........................................................................................
..........................................................................................
.............................................              ...............................
..........................................   .--.                .........................
.......................................     :*===:                    ....................
......................................      *@..==.                      .................
....................................        %@  -==                        ...............
...................................        .@%  .==.                        ..............
..................................         =@*   ==-......                   .............
.................................          %@=  .=======--===-:.              ............
.................................         .@@:  ========.::======-.            ...........
................................          +@@  -===================-            ..........
..............................            @@# -=========:---========-            .........
.............................            -@@*============:-==========.            ........
...........................              *@@+===========-:-===========             .......
.........................               .@@@=============:============-            .......
.......................               .-*@@%============--:============.            ......
......................              .===%@@*============--=:===========-            ......
....................              .=====@@@+============--:-============             .....
...................              -=====*@@@==============.-=============.            .....
..................              -======#@@#=============--:=============:            .....
................               -=======@@@*==============-:-============-             ....
..............                -=======+@@@================:=============-             ....
............                 .========#@@%===============--:-===========-             ....
..........                   -========@@@*===============.::-===========-             ....
........                     ========*@@@================-:-============-             ....
.......                      ========%@@#================ ..============-            .....
.......                .=-=+*#%%@@@@@@@@@@@@@@@%%%%#**++=-=-============-            .....
......             .=*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@+==============.           ......
.......           -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.    -=========:         ........
........          %@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#.      -========         .........
.........              .........                                .:----:        ...........
...........                                                                  .............
)" << '\n';
                cout << player.name << ": Hell yeah!\n";
                cout << player.name << " obtained the Clean-inator 9000!\n";
                player.wpn = "Vacuum Cleaner";
                vacuum = false;
            } else {
                cout << "Strong men don't need an easy game...\n";
            }

        } else if (step > 5 || step < 0) {
            cout << player.name << ": Can't go further...\n";
            if (step > 5) {
                step--;
            } else if (step < 0) {
                cout << player.name << " went back to the main entrance\n";
                mainhub(player, playerskill);
            }

        } else {
            cout << player.name << ": This place is empty...\n";
        }

        system("pause");
    }
}

Character mainbroom(Character &player, Skills &playerskill) {
    bool step1 = true, step2 = true, step3 = true, step4 = true, explore = true;
    string choice;
    int step = 0, boredom = 2;;

    while (explore) {
        system("cls");
        cout << R"(
.......................:###++++++++++**++++++++++++=...........................::::.::....
.......................:###+++++++++*****++++++++++=.....................::....::::::::...
.......................:###++++++++****##**++++++++=...................:::::::::---=:::...
.......................:###++++++*#****###**+++++++=...............:.:::-:---::-------:...
.......................:###+++++###********##++++++=............::::----=-+===--=-===-::..
.......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:
.......................:###+++*###########*****++++=..............:::--=---=--=--=====-::.
.......................:###+++###########***+++++++=..............::::::::::::::::::---:..
.......................:###++*#++*####*#*****++++++=....................::.::::::::--:::..
.......................:###++##**#########***++++++=...............:.::::..:::::::::--:-:.
.......................:###++***###########*#*+++++=..............::+=--::..::.::::--::::.
.......................:###+++**#############***+++=............::-@@@#-:::.......:::::::.
.......................:###++++++*##########***++++=.............:=@@@#--::........:..::..
.......................:###++++++*##****#*##**+++++=.............#@@@@@@-.::..............
.......................:###++++++*+++++*###*+++++++=.............%@@@@@@=:................
.......................:###++++++++++++++++++++++++=.............#@@@@@@-.................
.......................:###++++++++++++++++++++++++=..............=@@@%:..................
.......................:###++++++++++++++++++++++++=..............-@%@%...................
::..-::.:::............:###++++++++++++*+**++++++++=..............-@*@@:..................
-::-:----:-::..........:###+++++++++++**##*++++++++=..............-@+#@:..................
-=++=+*===--:..........:###++++++++++***#**++++++++=......................................
+*+++++++=-::..........:###+++++++**#*****+++++++++=......................................
++=+==--+--:...........:###+++++++*#*****++++++++++=......................................
=+-+=+==-:::...........:###++++++++++++*+++++++++++=......................................
+****+*+=--:::.........:###++++++++++++++++++++++++=.....::..:.::...........:-............
=**+****+=-:::.........:###+++++++*++++++++++++++++=.....:-:::-::........::----:::........
=-=*****+==--:::::-....:###**#***#++++*++++++++++++=.....:-=---:.......::=++=*+=-:........
=--*++=+====++==-:.....:###*#####*+++++++++++++++++=......:=-==:.:::...--++++====::.......
=--=-=-=:--=++==--:....:########**++++**+++++++++++=......::::::::::::--=+=---:::.........
+===---=----=*---::....:###*###*++++++*++++++++++++=.......:.:...::-=--=-==-::............
++++==-=-=----::-::....:###+***+++++++*++++++++++++=...........:-:=-==-==--::.............
==--:::=::--:::........:###+++++++++++*++++++++++++=...........::.:-:::-:--:..............
::...:.::..:...........:###+++++++++++*++++++++++++=..............-:..:::..:..............
)" << '\n';
        cout << "You are at the not-so-comfort room, graffiti is plastered everywhere, what do you want to do?\n";
        cout << "1. Go forward\n2. Go backward\n3. Go back to the main entrance\n";
        cout << player.name << ": ";
        cin >> choice;

        if (choice == "1") {
            cout << player.name << " went forward.\n";
            step++;
        } else if (choice == "2" && step > 0) {
            cout << player.name << " went backward.\n";
            step--;
        } else if (choice == "3") {
            cout << player.name << " went back to the entrance.\n";
            mainhub(player, playerskill);
        } else {
            cout << "Incorrect input, try again...\n";
            system("cls");
            mainfield(player, playerskill);
        }

        if (step == 1 && step1 == true) {
            cout << R"(
.......................:###++++++++++**++++++++++++=...........................::::.::....
.......................:###+++++++++*****++++++++++=.....................::....::::::::...
.......................:###++++++++****##**++++++++=...................:::::::::---=:::...
.......................:###++++++*#****###**+++++++=...............:.:::-:---::-------:...
.......................:###+++++###********##++++++=............::::----=-+===--=-===-::..
.......................:###++++##**######*#####++++=..............::-=-=+=+======++++==--:
.......................:###+++*###########*****++++=..............:::--=---=--=--=====-::.
.......................:###+++###########***+++++++=..............::::::::::::::::::---:..
.......................:###++*#++*####*#*****++++++=....................::.::::::::--:::..
.......................:###++##**#########***++++++=...............:.::::..:::::::::--:-:.
.......................:###++***###########*#*+++++=..............::+=--::..::.::::--::::.
.......................:###+++**#############***+++=............::-@@@#-:::.......:::::::.
.......................:###++++++*##########***++++=.............:=@@@#--::........:..::..
.......................:###++++++*##****#*##**+++++=.............#@@@@@@-.::..............
.......................:###++++++*+++++*###*+++++++=.............%@@@@@@=:................
.......................:###++++++++++++++++++++++++=.............#@@@@@@-.................
.......................:###++++++++++++++++++++++++=..............=@@@%:..................
.......................:###++++++++++++++++++++++++=..............-@%@%...................
::..-::.:::............:###++++++++++++*+**++++++++=..............-@*@@:..................
-::-:----:-::..........:###+++++++++++**##*++++++++=..............-@+#@:..................
-=++=+*===--:..........:###++++++++++***#**++++++++=......................................
+*+++++++=-::..........:###+++++++**#*****+++++++++=......................................
++=+==--+--:...........:###+++++++*#*****++++++++++=......................................
=+-+=+==-:::...........:###++++++++++++*+++++++++++=......................................
+****+*+=--:::.........:###++++++++++++++++++++++++=.....::..:.::...........:-............
=**+****+=-:::.........:###+++++++*++++++++++++++++=.....:-:::-::........::----:::........
=-=*****+==--:::::-....:###**#***#++++*++++++++++++=.....:-=---:.......::=++=*+=-:........
=--*++=+====++==-:.....:###*#####*+++++++++++++++++=......:=-==:.:::...--++++====::.......
=--=-=-=:--=++==--:....:########**++++**+++++++++++=......::::::::::::--=+=---:::.........
+===---=----=*---::....:###*###*++++++*++++++++++++=.......:.:...::-=--=-==-::............
++++==-=-=----::-::....:###+***+++++++*++++++++++++=...........:-:=-==-==--::.............
==--:::=::--:::........:###+++++++++++*++++++++++++=...........::.:-:::-:--:..............
::...:.::..:...........:###+++++++++++*++++++++++++=..............-:..:::..:..............
)" << '\n';
            Sleep(800);
            cout << "You step on a seemingly unassuming pile of trash..." << endl;
            Sleep(800);
            cout << "But a Trashsoldier jumps out!";
            Character trashsoldier2 = {"Trash Soldier", "Spear", 5, 50, 50, 10, 14, 7, 25, 2, 2, 0, 0, 0, 0};
            battleSimulation(player, playerskill, trashsoldier2);
            player = levelUp(player, playerskill, trashsoldier2);
            player = incentive(player, trashsoldier2);
            step1 = false;
        } else if (step == 2 && step2 == true) {
            cout << R"(
==========================================================================================
=================================================================================+++***===
===================================================================+++***##%%%@@@@@@@@@===
=====================================================+++***##%%%@@@@@@@@@@@@@@@@@@@@@@@===
=======================================+++**###%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===
====================================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===
------==============================*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@===
....    ....:::::::::::...:-========*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%#+=.:=
...    ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@#%%%%%%%*-::-=+*#######=    #
..     ...............    .:========*@@@@@@@@@@@@@@@@@@@@@@@@########.       .######*-::+#
.     ...............    ..-========*@@@@@@@@@@@@@@@@@@@@@@@@########=       *############
     ...............    ...:=========++++++*-   =************#########      =#############
    ................    ...-================:   -============#########-     *#############
    ...       .....    ....-================-  :=============#########+    +##############
   .....     .....    .....-=================. .=============##########   .###############
  ................    .....-=================-:-=============##########   -###############
  ...............    ..... .=================================##########=.:*###############
 ...............    .::::   :.::==++=========================#############################
....  .........  .-=+++=:    .    :++========================#############################
...   ...:::-=-   ::::. .==++++=  ===========================#############################
...   -==+=-.         :++++*****--===========================#############################
-==   :..         ..  =*********-:===========================#############################
-.         :--=+++++. =**+***++=-:===========================######################  #####
.     .-=++++++*****- -++++=====--===========================##########+-:=#######-. =####
-.    ++++++*********:-====---==--===========================#######*-.  :*#######  -*####
+=   :++****++******+--=--::::::--:----======================######*  .=##########- =#####
+:   =*****+**+++===--::::::::.      :::::-------============#####+::-:..:*###*.+##+ +####
**=  -****+======--::..::::..         .::::::::::::-------===###+. :--=#= +###= -*#* =####
**- .****====---:::::. :::            ::::::::::::::::::::::-###++*##*=  --::##= :. +#####
***+**++==--:::::::::  ::.           .::::::::::::::::::::::-######+.  ..  .+#+  :. ######
+*+:.==--::::::.                    .:::::::::::::::::::::::-#######+*#*..+###+.   -######
===  ::::::::                   ..::::::::::::::::::::::::::-###############-.  .: *######
--:   :::::.                 .::::::::::::::::::::::::::::::-###########=-:. .:::. =######
)" << '\n';
            Sleep(800);
            cout << "Going further in the comfort room, toilet paper and sink water spreads out chaotically in the vicinity..." << endl;
            Sleep(800);
            cout << "A Rat mage emerges from the sink!";
            Character ratmage2 = {"Rat Mage", "Reekburst", 6, 55, 55, 10, 11, 5, 30, 3, 3, 0, 0, 0, 0};
            battleSimulation(player, playerskill, ratmage2);
            player = levelUp(player, playerskill, ratmage2);
            player = incentive(player, ratmage2);
            step2 = false;

        } else if (step == 3 && step3 == true){
            cout << "You feel an intense aura up ahead, and you passed by a janitor's stool, would you like to take a rest? (Y/N)\n";
            cout << player.name << ": ";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << "You took a short rest\n";
                player.mana = player.maxmana;
                player.hp = player.maxhp;

                boredom--;
            } else if ((choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") && boredom <= 0) {
                cout << "You already felt the boredom from resting, you do not want to rest anymore...\n";
                step3 = false;
            } else {
                cout << "Strong men don't need rest anyway...\n";
            }

        } else if (step == 4 && step4 == true){
            cout << "You feel an intense aura up ahead, are you sure you want to go ahead? (Recommended level: 8+)\n";
            cout << "Go ahead? (Y/N)\n";
            cin >> choice;

            if (choice == "Y" || choice == "y" || choice == "Yes" || choice == "yes") {
                cout << R"(
++++++++++++++++:....................................................:++++++++++++++++-...
++++++++++++++++:.............................................  .....:++==-::-:-++++++-...
+++=======++++++:..........................................     .....:++-:.    .-=++++-...
++=-::::-=++++++:......... ..............................      ......:++=:.   ..:-=+++-...
+==-:...:-++++++:........   .......................... ..      ......:+++-::::-===++++-...
++=:....:=++++++:......       .....................  .....     ......:+++=---=++++++++-...
++=:...:-=++++++:......       ..................     ......     .....:++++----==++++++-...
+++-::.:=+++++++:......       ................       ......     .....:++++=----=++++++-...
+++=---=++++++++:......      .................      .......    ......:+++=--:--=++++++-...
+++==--=++++++++:......     ............    ....    ........   ......:++++=--:--=+++++-...
+++++===++++++++:.......   ............    .....     ................:++++=------=++++-...
++++++++++++++++:................................   .................:++++=-::::-=++++-...
++++++++++++++++:....................................................:+++++-:::-=+++++-...
++++++++++++++++:....................................................:++++++===+++++++-...
++++++++++++++++:.........................::::.......................:++++++++++++++++-...
++++++++++++++++:....................:-=+++++++=-....................:++++++++++++++++-...
++++++++++++++++:.............::::--++++++++++++++-..      ..........:++++++++++++++++-...
++++++=+++++++++:...........:+++++++++===------==++-:.     ..........:++++++++++++++++-...
+++++==+++++++++:...........=++++++++=-----------=++++++=   .........:+++++++**=-+***+-...
++++++=+++++++++:....  .....++++++++--------------=++++++   .........:+++++++*+   ****-...
+++++====+++++++:....    ...++++++++---------------++++++:   ..... ..:++++++++=   +*++=...
++++++==--=+++++:...........=++++++=-------------:-+++++++-  ........:+++++++++   =+++=...
++++++==---=++++:...........=+++++++------------: =++++++++  ........:+++++++++   -+++=...
+++====-====++++:...........-++++++++-----------. +++++++++  ........:++++++++++=+++++-...
+++==---===+++++:...........:+++++++++=---------  +++++++++: ........:+++---::=+++++++=...
++++++=====+++++:............=+++++++++====----: .+++++++++..........:+++-....:=++++++=...
++++++++==++++++:...      ...-+++++++++++=        -+++++++=..........:++===:..:-=+++++-...
+++++====+++++++:...       ...=+++++++++=         :+++===-..... .....:++=--:--==++++++=...
++++=---==++++++:...       ....:++++==-.           -++=.......    ...:++-:::--=-===+++=...
++=-::..:-=+++++:.....    .....--:-=-.              :++.....      ...:++===------===++-...
++=:.   :-++++++:......   ....   ....               :++.....     ....:+++++=-:::::-==+-...
++=-.:::==++++++:.............  -++--            .:=+++..............:++++=-::...:-=++=...
+++====+++++++++:.............  =+++++=::.       -+++++..............:++++++==-:-==+++=...
)" << '\n';
                Sleep(800);
                cout << "Before you stands a toilet clogged way above the brim with toilet paper, someone's shoe, and..";
                Sleep(200); ".";
                Sleep(200); "a plunger..";
                Sleep(200); ".";
                Sleep(200); "'s handle...";
                Sleep(800);
                cout << endl << "Withing the mass, a violent shaking occurs as you brace yourself for what's about to go down.";
                Sleep(300); ".";
                Sleep(600); ".";
                cout << endl << "The Rat King jumps out!" << endl;
                Sleep(500);
                Character ratking = {"Rat King", "Rat-tling", 10, 75, 75, 8, 11, 8, 30, 4, 4, 0, 0, 0, 0};
                battleSimulation(player, playerskill, ratking);
                step4 = false;

                epilogue(player);
            } else {
                cout << "Feeling afraid of the aura ahead, you decide to retreat...\n";
                step--;
            }


        } else if (step > 4 || step < 0) {
            cout << player.name << ": Can't go further...\n";
            if (step > 4) {
                step--;
            } else if (step < 0) {
                cout << player.name << " went back to the main entrance\n";
                mainhub(player, playerskill);
            }

        } else {
            cout << player.name << ": This place is empty...\n";
        }
        system("pause");
    }
}

void epilogue (Character &player) {
    system("pause");
    system("cls");
    cout << R"(
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------
--------------------------------=+++*****++==---------------------------------------------
----------------------------=+*****************=------------------------------------------
---------------------------***********+++===+***+-----------------------------------------
---------------------------******-.            =*=----------------------------------------
--------------------------=*****:               +=----------------------------------------
--------------------------=****=                :=----------------------------------------
---------------------------+**-                 .=----------------------------------------
---------------------------:=-                   -----------------------------------------
---------------------------:-:                  =-----------------------------------------
---------------------------+*-    .:-=====-::  :*-----------------------------------------
----------------------------**:   +*=-----=+*--**-----------------------------------------
----------------------------***=:.*+       .****+=----------------------------------------
-------------------------====+*****=..=*+:-+***+=====.::----------------------------------
--------------------:..==========************=======-    .:-------------------------------
-------------:::::.    .======== .+********=.-======.     : .-----------------------------
------------   . ..-:   .=======:  .=****+.  ======:     :.  .-=--------------------------
-----------:        .=.  .=======    =++=:  :======      =-*%@@@@@@#+---------------------
-----------          :=   :======:   ====:  ======.  .+#@@@@@@@@@@@@@@#-------------------
----------:           =:   :======.  ====- -=====. -#@@###*#@@@@@@@@@@@@+-----------------
----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------
---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------
---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------
---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------
--------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------
---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------
---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------
--------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------
--------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------
--------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+.  :@@@@@@@@@@@@@@*-------------------
--------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------
)" << '\n';
    cout << "\nPrincipal: You have slain the rat king, " << player.name << "...\n";
    cout << "\nPrincipal: Good job, you have used your critical and logical thinking to rid the problem of which janitors had trouble over.\n";
    cout << "\nPrincipal: Expect that you will pass 8th grade.\n";
    system("pause");
    system("cls");

    cout << "Narrator: The young boy has managed to defeat the Rat King and has managed to clean the school...\n";
    Sleep(2000);
    cout << "Narrator: With that, the young boy " << player.name << " managed to fulfill their community service and saved the school from its grimy threats...\n";
    Sleep(2000);
    cout << "\n\n";
    Sleep(2000);
    cout << "Narrator: The end... for now..\n";
    cout << "Narrator: You have finished TrashFighters Version 1, stay tuned for the full release!\n";
    Sleep(2000);
    exit(0);
}

void ascii(Character &enemy){
    if (enemy.name == "Trashman") {
        cout << R"(
-------------------------------::..         :---------------------------------------------
---------------------------:.                ---------------------------------------------
--------------------------.              .   :--------------------------------------------
------------------------:                     :-------------------------------------------
------------------------.           .::        .------------------------------------------
-----------------------:        .:-=-:::.        .:---------------------------------------
-----------------------.     ..:--:   ..            :-------------------------------------
-----------------------        .           .=    .    .:------::--------------------------
--------------------:.:.    ...        -==++      .--.   ::....:--------------------------
----------------------:..:----.          .          .::    .------------------------------
------------------------=*=..                           ..   .:---------------------------
-----------------------#@#*@#=.                   -++.     :.  .:-------------------------
-----------------------@%  =@@@@*=.         .:=+%#-:*@.      .    :-----------------------
----------------------:*@@@@@@@@@%.        .@@@@@+::*@.             .:--------------------
-------------------:.   :#@@@@%+:           .*@@@@@@*:                .:------------------
-----------------:.                             ...                      :----------------
----------------:                                                  .      ----------------
---------------:                                                    ..    :---------------
---------------.                                                     .    :---------------
---------------:                ..:..                                :    :---------------
----------------.            ...     ..........                    :.     :---------------
-----------------          ..                   .                ::       :---------------
-----------------:                ..........                  .:-:..     :----------------
------------------:.                                      .::-=--:     :------------------
--------------------:.                                    ::=-:.    .:--------------------
--------------::..                                     ...:.        .::-------------------
------------.                                                          ..:----------------
----------:.                                                               :--------------
----------.                               :-:.                              .-------------
----------:                             .:---:                               .------------
------------..                       ..:------:.                             .------------
---------------:::..:::::::----:::::------------::...                        .------------
------------------------------------------------------:..                   .-------------
)" << '\n';
    }
    if (enemy.name == "Trash Soldier") {
        cout << R"(
-------------------------------::..         :---------------------------------------------
---------------------------:.                ---------------------------------------------
--------------------------.              .   :-===========--------------------------------
------------------------:                     #@@@@@@@@@@@@@%%*+=-------------------------
------------------------.           .::        =@@@@@@@@@@@@@@@@@@%%%%%######-------------
-----------------------:        .:-=-:::.        :-===++*%@@@@@@@@@@@@@@@@@@@#------------
-----------------------.     ..:--:   ..            :--------==+*#@@@@@@@@@@#-------------
---------+#@@%#--------        .           .=    .    .:------::---+%@@@@@#+--------------
--------#@@@@@@@*---:.:.    ...        -==++      .--.   ::....:-----=+++-----------------
-------#@@@@@@@@@*----:..:----.          .   .=--   .::    .------------------------------
-------@@@@@@@@@@@#-----=*=..               .-.-:       ..   .:---------------------------
------*@@@@@@@@@@@@%=--#@#*@#=.                 . -++.     :.  .:-------------------------
------@@@@@@@@@@@@@@@+-@%  =@@@@*=.         .:=+%#-:*@.      .    :-----------------------
-----+@@@@@@@@@@@@@@@@-*@@@@@@@@@%.        .@@@@@+::*@.             .:--------------------
-----%@@@@@@@@@@@@@%+.  :#@@@@%+:           .*@@@@@@#:                .:------------------
-----%@@@@@@@@@@@%-                             ... +..                  :----------------
-----%@@@@@@@@@@#                                 ::-=.            .      ----------------
-----%@@@@@@@@@@                                   ::*:.            ..    :---------------
-----=#@@@@@@@@+                                     =               .    :---------------
---------=+*%@@*                ..:..               :+-              :    :---------------
------------=@@@=            ...     ..........      -             :.     :---------------
--------------=+=          ..                   .                ::       :---------------
-----------------:                ..........                  .:-:..     :----------------
------------------:.                                      .::-=--:     :------------------
--------------------:.                                    ::=-:.    .:--------------------
--------------::..                                     ...:.        .::-------------------
------------.                                                          ..:----------------
----------:.                                                               :--------------
----------.                               :-:.                              .-------------
----------:                             .:---:                               .------------
------------..                       ..:------:.                             .------------
---------------:::..:::::::----:::::------------::...                        .------------
------------------------------------------------------:..                   .-------------
)" << '\n';
    }
    if (enemy.name == "Rat Mage") {
        cout << R"(
.............................#+..........:+********+..........%:..........................
..........................:*#*..........=***********=.........-==:.......*-...............
.........................*#=..........:**************............=.......%#...............
........................-%*..........-***************+-..................-=...............
........................=+.........-********************:.................................
......................==--.........*********************+..-==++-...::....................
......................=+.....*++:=**********************###*+===#=...*....................
......................-#....+*:+*********************###+-::::::*+...*....................
.....................=#%....+#=*****************####%#+-:::::::-%-...=....................
.....................+%%:....#*************###%%%%%*-:::::::::+#=.........................
....................:+==....:=*********###%%%%**#%%%-::::-=+*#=...........................
....................*:....:*******+#*. +%%%%*  .-%%%*###**+-:..........*..................
....................-......:---:...*%%#%%%%%%***%%%%:.................::..................
...............-#....:........:::::+%%%*--=*%%%%%%%*::::::...:-...........................
...............................::::-%%####*#%%%%%%+::::......+=...........................
...............................:--+*#%%%%%%%%%%%%#*+:::......=#:.....:*:..................
...................:+.........:..=***%%%%%%%%%%#*****-........*:.....:%...................
..................:=#...........=****%%%%%%%%%%*******........#:.....:*+..................
..................:%%..........+*****%%%%%%%%%#*******+.......#=-:........................
..................:#=.........+***#*#%%%%%%%%%#********+........=##+......................
..................=#.........-**#*+*#%%%%%%%%%#*********:........-=#....:.................
..................+*.........+#%%:-*#%%%%%%%%%#**##%#***=..........*+:..=*:...............
..................#=.........*#+= **#%%%%%%%%%#*+#%%#****:...............==...............
..................%:.........*+:::=*#%%%%%%%%%+:::+%#****+...............+*...............
..................%-.........+*--+**#%%%%%%%%%*---********:..............:++..............
.................:%:.........=*.****#%%%%%%%%%#***********:...............:*..............
.................=%..........-******#%%%%%%%%%#***********=...............:#.*............
.................%=..........-*******%%%%%%%%%#************:::::::::.......:-%=...........
...............#*%:..........=*******#%%%%%%%%#************+:.......::.......=*...........
...............#*:.......::::=*******#%%%##%%%#************+-................%=...........
...............-%:.......:::::=*******=-:...:-*******-:=**-................=#+............
................-*+:...........:+*****+......-*****+-::.:..................+:.............
.................................-****=......+**+-........................................
)" << '\n';
    }
    if (enemy.name == "Rat King") {
        cout << R"(
++++++++++++++++++++++++++*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++*****+==++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++=--+++=----===++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++=-----------------=+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++==+++=--------+------------+++=-::....-++++++++++++++++++++++++++++++++++++++
+++++++++++=.-:-==--------=*+---*=----+==-..:--===-.=+++++++++++++++++++++++++++++++++++++
+++++++++++-.==::=---*+=--****+****++**-.:-=======-.=+++++++++++++++++++++++++++++++++++++
+++++++++++=.-===*+=+*************##+=::-========-::++++++++++++++++++++++++++++++++++++++
++++++++++++:.-====*+********++==-:..--========--.:=++++++++++++++++++++++++++++++++++++++
+++++++++++++-.:--=:.:...............-=====--::.:=++++++++++=:..:-::-=++++++++++++++++++++
+++++++++++++++=-::.    .....   . .........::-=+++===+++++++.         =+++++++++++++++++++
+++++++++++++++++++...........   ....-+++++++++++-:::::-=+==#.        .+++=-=+++++++++++++
+++++++++++++======.....-:::.........===+++++++++:-===--:.  :##=:.   .+*=::-.+++++++++++++
++++++++++++++=====-....::-:........-=======+++++-:-=====-:.   -=+*#**=. -=-:+++++++++++++
++++++++=++++++++===-..............+++===+++++++++-:--=====:...:::.     .--:=+++++++++++++
+++++++++++++=====##*.............*###*===++++++++++=::::::+*%@@@@+*@#%#-:-+++++++++++++++
++++++++++++++++++##=...........-#####*+++++++++++++++++===-.:*##+..=++:++++++++++++++++++
++++++++++++++++=-##-..........=####=--=+++++++++++++++====-......--:..:====++++++++++++++
+++++++++++++++---*#..........-####+-----++++++++++++++++===-.....:+=..-===+++++++++++++++
++++++++++++++----+#:........-###+--------+++++++++++++++==: ........::  :==++++++++++++++
+++++++++++++=----=#-........=#*=---------=++++++========-    =#*=:-#@-  .=+++++++++++++++
++++++++++++=---:--=:.....:==+*-:::-------=+===*+=====++=.    .*@@#*@@:   -+++++++++++++++
++++++++++++=-::::-:......:***+-...:------=+==*++***####=     .:+@*=@+:    -++++++++++++++
+++++++++++++--===-:........:-+*+=---------*+*##########      .::=+-#:.     ++++++++++++++
+++++++++++++=-==--:.........:--===--------*###########*      .:::::-:.  .  =+++++++++++++
+++++++++++++=-----:.........:-------------+########*+*=    .--:::::::  :==.++++++++++++++
+++++++++++++=-----..........:-------------+####*+++*##-    .:-:::::::   :.-++++++++++++++
+++++++++++++------..........:------------+#======++**#:      .:::::::     :++++++++++++++
+++++++++++++=-----..........:----------+*#+==+*+======.       :::::::     :++++++++++++++
+++++++++++++#+----..........:------=+###=+++++++++++++-       :::::::     -++++++++++++++
+++++++++++++*#*+=-:......::..====+*###*-=++++++++++++++. ..   :::::::     =++++++++++++++
++++++++++++++**##*=--==++++++*##****++++++++++++++++++++++++: .==+==-  .-++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
)" << '\n';
    }
}

Character incentive(Character &player, Character &enemy) {
    string bless = "N/A";
    int tries = 3;

    if (player.lvl <= (enemy.lvl + 1)) {
        while (tries > 0) {
            system("cls");
            cout << R"(
    ------------------------------------------------------------------------------------------
    ------------------------------------------------------------------------------------------
    ------------------------------------------------------------------------------------------
    --------------------------------=+++*****++==---------------------------------------------
    ----------------------------=+*****************=------------------------------------------
    ---------------------------***********+++===+***+-----------------------------------------
    ---------------------------******-.            =*=----------------------------------------
    --------------------------=*****:               +=----------------------------------------
    --------------------------=****=                :=----------------------------------------
    ---------------------------+**-                 .=----------------------------------------
    ---------------------------:=-                   -----------------------------------------
    ---------------------------:-:                  =-----------------------------------------
    ---------------------------+*-    .:-=====-::  :*-----------------------------------------
    ----------------------------**:   +*=-----=+*--**-----------------------------------------
    ----------------------------***=:.*+       .****+=----------------------------------------
    -------------------------====+*****=..=*+:-+***+=====.::----------------------------------
    --------------------:..==========************=======-    .:-------------------------------
    -------------:::::.    .======== .+********=.-======.     : .-----------------------------
    ------------   . ..-:   .=======:  .=****+.  ======:     :.  .-=--------------------------
    -----------:        .=.  .=======    =++=:  :======      =-*%@@@@@@#+---------------------
    -----------          :=   :======:   ====:  ======.  .+#@@@@@@@@@@@@@@#-------------------
    ----------:           =:   :======.  ====- -=====. -#@@###*#@@@@@@@@@@@@+-----------------
    ----------            =-    :======. -===:-=====.:%@@@@@@@@**@@@@@@@@@@@%-----------------
    ---------:           .=:     .======:-=========.*@@@@@@@@@@@-@@@@@@@@@@%%-----------------
    ---------.           :=.       -=============++%@@@@@@@@@@@@@######****%*-----------------
    ---------     .:-===-==         .========+*#@@@@@@@@@@@@@@@@@@@%*@@@@@@@=-----------------
    --------: .-==========:           :=+*#%@@@@@@@@@@@@@@@@@@@@@@++@@@@@@@@------------------
    ---------========-:.-.           :+#@@@@@@@@@@@@@@@@@@@@@@@#==%@@@@@@@@#------------------
    ---------=====-.            .-+%@@@@@@@@@@@@@@@@@@@@@@@@@*+*@@@@@@@@@@@+------------------
    --------====:           .+*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-------------------
    --------=-.            +@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*:=@@@@@@@@@@@@@@%-------------------
    --------.            .%@@@@@@@@@@@@@@@@@@@@@@@@@@@%+.  :@@@@@@@@@@@@@@*-------------------
    --------            :@@@@@@@@@@@@@@@@@@@@@@@@@@@#-      -@@@@@@@@@@@@@*:------------------
    )" << '\n';
            cout << "Principal: Welcome, " << player.name << "...\n";
            cout << "Principal: For cleaning up trash in the school, I shall give you incentives! Choose wisely, you have " << tries << " left \n";
            cout << "1. Improve ATK\n";
            cout << "2. Improve DEF\n";
            cout << "3. Improve SPD\n";
            cout << "4. Improve HP\n";
            cout << "5. Improve Recovery\n";
            cout << "6. Improve MANA\n";

            cout << "Principal: Enter your choice, student...\n";
            cout << player.name << "'s choice: ";
            cin >> bless;

            cout << "Principal: Here, take this...\n";

            if (bless == "1") {
                cout << player.name << " feels stronger!\n";
                player.pow++;

                if (player.pow > player.maxpow) {
                    cout << player.name << "'s ATK cannot be increased! \n";
                    player.pow = player.maxpow;
                    tries++;
                }
                tries--;
            } else if (bless == "2") {
                cout << player.name << " feels bulkier!\n";
                player.def++;

                if (player.def > player.maxdef) {
                    cout << player.name << "'s DEF cannot be increased! \n";
                    player.def = player.maxdef;
                    tries++;
                }
                tries--;
            } else if (bless == "3") {
                cout << player.name << " feels faster!\n";
                player.spd++;

                if (player.spd > player.maxspd) {
                    cout << player.name << "'s SPD cannot be increased! \n";
                    player.spd = player.maxspd;
                    tries++;
                }
                tries--;
            } else if (bless == "4") {
                cout << player.name << " feels vitalized!\n";
                player.maxhp+=5;
                player.hp+=5;
                tries--;
            } else if (bless == "5") {
                cout << player.name << " feels more resilient!\n";
                player.rec+=5;
                tries--;
            } else if (bless == "6") {
                cout << player.name << " feels more energetic!\n";
                player.maxmana++;
                player.mana++;
                tries--;
            } else {
                cout << "Principal: Wait, thats wrong\n";
            }

            system("pause");
            system("cls");
        }

        cout << "--------\n";
        cout << player.name << "'s stats\n";
        cout << "LVL: " << player.lvl << "\n";
        cout << "HP: " << player.hp << " / " << player.maxhp << "\n";
        cout << "MANA: " << player.mana << " / " << player.maxmana << "\n";
        cout << "WEAPON: " << player.wpn << "\n";
        cout << "ATK: " << player.pow << "\n";
        cout << "DEF: " << player.def << "\n";
        cout << "SPD: " << player.spd << "\n\n";

    } else {
        cout << "System: No incentive due to being too higher leveled than the enemy.\n";
    }

    return player;
}
