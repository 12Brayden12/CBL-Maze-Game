commit 9a02bfa4f8245901ca871fcb15d9f076ae1baf81
Merge: 1dbded0 89fefdd
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 26 19:15:28 2025 +0100

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 1dbded04496571d7832db124120f7381e4755a88
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 26 19:15:24 2025 +0100

    pdf added

 GDD Report.pdf                | Bin 0 -> 155101 bytes
 Java Game Product Backlog.pdf | Bin 0 -> 112375 bytes
 2 files changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 GDD Report.pdf
 create mode 100644 Java Game Product Backlog.pdf

commit 89fefddaa18a0c65d9c3e37f235745600f031c73
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 26 18:20:35 2025 +0100

    unecessary stuff

 Board.java         | 2 +-
 GameActions.java   | 4 ++--
 Player.java        | 4 ++--
 TimerAndScore.java | 2 +-
 4 files changed, 6 insertions(+), 6 deletions(-)

commit c1e76bf2ba138b263c9a4ec554026e32a917e04e
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 26 13:00:09 2025 +0100

    typo in game menu

 GameMenu.java | 5 ++---
 1 file changed, 2 insertions(+), 3 deletions(-)

commit c02b2dfa825570422d16f0ff97103e25097e41ee
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 26 12:57:29 2025 +0100

    Some grammatical/syntax correction in the "README" fiile.

 README.txl | 14 +++++++-------
 1 file changed, 7 insertions(+), 7 deletions(-)

commit 8badf6ef67cb2c9b96c025cb93e0e6028b7c06a3
Merge: 73caea6 1377dc1
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 26 12:25:06 2025 +0100

    Merge feature/scoring into main

commit 1377dc1b3c0dd02c6326f832b0f2f7f3c7f00d94
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 26 12:24:20 2025 +0100

    Final scoring system

commit 73caea65a7295b125e95b334ab45cb2fea170b88
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 26 12:19:39 2025 +0100

    README added

 README.txl | 22 ++++++++++++++++++++++
 1 file changed, 22 insertions(+)
 create mode 100644 README.txl

commit d9b65ee5e53fc67d5c7d1e90e780d100cd024a13
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sat Oct 25 00:12:45 2025 +0200

    Checkstyle mostly fixed and comments have been added

 Board.java                  | 571 +++++++++++++++++++++++---------------------
 Difficulty2.java            |  40 +++-
 FakeFruit.java              |  14 +-
 Fruit.java                  |   8 +
 Functions/Entity.java       |  24 --
 Functions/Exit.java         |  14 --
 Functions/FakeFruit.java    |  16 --
 Functions/Fruit.java        |  16 --
 Functions/TimerManager.java |  30 ---
 Functions/Trap.java         |  14 --
 GameActions.java            |  32 ++-
 GameMenu.java               | 190 +++++++--------
 GameObject.java             |  17 +-
 MazeGameGUI.java            | 270 +++++++++++----------
 Player.java                 |  32 ++-
 Position.java               |  13 +
 SoundManager.java           |  18 +-
 StartGame.java              |   3 +
 TimerAndScore.java          |  30 ++-
 Trap.java                   |   9 +-
 20 files changed, 708 insertions(+), 653 deletions(-)
 delete mode 100644 Functions/Entity.java
 delete mode 100644 Functions/Exit.java
 delete mode 100644 Functions/FakeFruit.java
 delete mode 100644 Functions/Fruit.java
 delete mode 100644 Functions/TimerManager.java
 delete mode 100644 Functions/Trap.java

commit 2ee3cce508fa95007006e444c8ca6c9ae383c2b4
Merge: f3efd1c 061a3c2
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Fri Oct 24 21:59:21 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit f3efd1c78cc913c0f247ff96182f8dfef8cb177b
Merge: fdf06ba b7cc4cb
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Fri Oct 24 21:59:17 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 061a3c24cfc93e5aa4eebf7e00e5f88795c9bcec
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Fri Oct 24 21:25:40 2025 +0200

    Further checkstyle corrections

 Board.java       |  6 ------
 MazeGameGUI.java | 30 ++++++++++++++++--------------
 2 files changed, 16 insertions(+), 20 deletions(-)

commit 3f1974d328a9111ec16af9efc53b6b39085871af
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Fri Oct 24 21:15:33 2025 +0200

    Checkstyle corrections

 Board.java         | 473 +++++++++++++++++++++--------------------------------
 Difficulty2.java   |  13 +-
 GameActions.java   |  31 ++--
 GameMenu.java      | 110 ++++++-------
 GameObject.java    |  29 ++--
 MazeGameGUI.java   |  62 ++++---
 Move.java          |  42 -----
 MoveDown.java      |   6 -
 MoveLeft.java      |   6 -
 MoveRight.java     |   7 -
 MoveUp.java        |   7 -
 Player.java        |  29 ++--
 Position.java      |   7 +-
 SoundManager.java  |  13 +-
 TimerAndScore.java |  19 ++-
 15 files changed, 340 insertions(+), 514 deletions(-)
 delete mode 100644 Move.java
 delete mode 100644 MoveDown.java
 delete mode 100644 MoveLeft.java
 delete mode 100644 MoveRight.java
 delete mode 100644 MoveUp.java

commit fdf06baddec4952c531ab517aa28cb017d4233a0
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Fri Oct 24 20:41:17 2025 +0200

    checkstyle partialy

 Board.java                  | 41 ++++++++++++++++++--------
 Difficulty2.java            | 18 ++++++++----
 FakeFruit.java              |  8 ++++-
 Fruit.java                  |  6 ++++
 Functions/Entity.java       | 24 ---------------
 Functions/Exit.java         | 14 ---------
 Functions/FakeFruit.java    | 16 ----------
 Functions/Fruit.java        | 16 ----------
 Functions/TimerManager.java | 30 -------------------
 Functions/Trap.java         | 14 ---------
 GameActions.java            | 71 +++++++++++++++++++++++++++++----------------
 GameMenu.java               | 47 +++++++++++++++++++++---------
 GameObject.java             | 52 ++++++++++++++++++++++++---------
 13 files changed, 171 insertions(+), 186 deletions(-)
 delete mode 100644 Functions/Entity.java
 delete mode 100644 Functions/Exit.java
 delete mode 100644 Functions/FakeFruit.java
 delete mode 100644 Functions/Fruit.java
 delete mode 100644 Functions/TimerManager.java
 delete mode 100644 Functions/Trap.java

commit b7cc4cb693650e3c4f0520bb9ebf7538b36a010f
Merge: 73f75d0 42640db
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Fri Oct 24 12:51:35 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 73f75d028e70bf384d44ce7156d2335641317632
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Fri Oct 24 12:51:29 2025 +0200

    Minor changes, enlarged windows so the size of the maze is better suited to the windows, final parameters of each of the maze chosen.

 Board.java         | 19 ++++++++++---------
 Difficulty2.java   | 16 ++++++++--------
 MazeGameGUI.java   |  2 +-
 TimerAndScore.java |  3 +--
 4 files changed, 20 insertions(+), 20 deletions(-)

commit 42640dbdb66d3e3d69deacf67b1871d3b71fe470
Merge: 31bcbe1 fc9cfb2
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 23 10:51:17 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 31bcbe19f3aeef28af2065217a08eea98d6ac218
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 23 10:51:14 2025 +0200

    checkstyle check

 Board.java | 30 +++++++++++++++++-------------
 1 file changed, 17 insertions(+), 13 deletions(-)

commit fc9cfb268aff44075f74b1037da6741d005713da
Merge: b4baa42 75518c7
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Thu Oct 23 01:12:54 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 75518c7f7a7f04ab3eb3c665fa4a1dcbd389c130
Merge: c3ffa15 c961df6
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:39:12 2025 +0200

    Merge dev into main for release v2.0

commit c961df64873199aa102bef5a2375c287ec72a1ea
Merge: c4c2259 d05a8c2
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:38:35 2025 +0200

    Merge feature/score into dev

commit d05a8c2982e3eb109ea3b401249154f192ab421a
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:37:54 2025 +0200

    Add timer and score tracking (TimerAndScore)

commit c4c225945aea83372ea6ee7597a74eb40cc91623
Merge: 5db6caf 91e21ed
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:36:49 2025 +0200

    Merge feature/sound into dev

commit 5db6caf3b0280e05c4bcabedf32847213edd360a
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:33:14 2025 +0200

    Ädd sound manager and background music (SoundManager)

commit aab9f1f8f6fd09369ea14e8a703c1c6df69dfbb8
Merge: 1ef9c68 1662388
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:32:14 2025 +0200

    Merge feature/player into dev

commit 1662388e5805ea1278d34e423cca0c6016ebb644
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:31:33 2025 +0200

    Implement player logic and movement (Player)

commit 1ef9c684d54d2c4a6df699c34c15a3a7bc45be51
Merge: 4b9df23 ef1dabe
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:30:23 2025 +0200

    Merge feature/gui into dev

commit 4b9df2315f96d41e38fbb0976a939dc5913bc5f8
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:29:47 2025 +0200

    ADD GUI system (MazeGameGUI, GameMenu)

commit c3ffa15ddf67d6013580c70ae61f756f4c8b4e8a
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Wed Oct 22 22:22:13 2025 +0200

    Player JPG replace color, use draw Image

 Difficulty2.java | 2 +-
 GameActions.java | 3 ++-
 2 files changed, 3 insertions(+), 2 deletions(-)

commit b4baa4261de6676eaa900c43ec2fcfdaf4c40e20
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Wed Oct 22 12:49:47 2025 +0200

    Cosmetic changes with regard to the "game over" and "win" panels. An attempt to fix the random generation of  traps within the accessible path, by creating the separate method and collecting all valid positions,  however it finally did not succed.

 Board.java           |  80 ++++++++++++++++-------
 ControlReversal.java |  26 --------
 Difficulty.java      |  42 ------------
 Difficulty2.java     |  14 ++--
 GameActions.java     | 178 +++++++++++++++++++++++++++------------------------
 SoundManager.java    |  19 ++++++
 TimerAndScore.java   |   2 +-
 7 files changed, 177 insertions(+), 184 deletions(-)
 delete mode 100644 ControlReversal.java
 delete mode 100644 Difficulty.java

commit 7e6484afcef0ba3820941ce93bb5e83e614ec99f
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 21 14:05:36 2025 +0200

    Add Timer and Score tracking

commit 91e21edfffbdc3fff0a7cf7ada8379bdf4329143
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 21 14:02:37 2025 +0200

    Add SoundManager for in-game sounds

commit 56daacd9bf5489596fbc19301717aba35ba04b3d
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 21 14:00:57 2025 +0200

    Implement core logic (Player, Board, GameActions)

commit ef1dabef3ab67d0b91189913837eaf81760d9b3a
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 21 13:58:18 2025 +0200

    Merge feature/logic into dev

commit 0274c877da23863513d5d532e77427b245941977
Merge: f7e8312 b3c431f
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Mon Oct 20 18:11:00 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit f7e83122b5b9f27147ce59d3a7fe7d2430e4bdd0
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Mon Oct 20 17:24:18 2025 +0200

    bgm added

 .vscode/launch.json  |   7 ++++
 Difficulty2.java     |  28 +++++++++++++---
 GameActions.java     |  89 +++++++++++++++++++++++++++++++++++++--------------
 GameMenu.java        |   7 ++--
 MazeGameGUI.java     |  49 +++++++++++++++++++++++++---
 Player.java          |  18 +++++------
 TimerAndScore.java   |  82 +++++++++++++++++++++++++++++++++++++++++++++++
 images/exit.jpg      | Bin 0 -> 64025 bytes
 images/fakefruit.jpg | Bin 0 -> 57282 bytes
 images/fruit.jpg     | Bin 0 -> 61469 bytes
 images/player.jpg    | Bin 0 -> 71418 bytes
 images/trap.jpg      | Bin 0 -> 111012 bytes
 sounds/bgm.wav       | Bin 0 -> 7034030 bytes
 13 files changed, 236 insertions(+), 44 deletions(-)
 create mode 100644 TimerAndScore.java
 create mode 100644 images/exit.jpg
 create mode 100644 images/fakefruit.jpg
 create mode 100644 images/fruit.jpg
 create mode 100644 images/player.jpg
 create mode 100644 images/trap.jpg
 create mode 100644 sounds/bgm.wav

commit b3c431f795c01abc994d4f7c4e4140e556534cef
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 19 18:34:38 2025 +0200

    Minor correction to player and GameActions files

 GameActions.java   | 14 +++++++-------
 TimerAndScore.java |  2 +-
 2 files changed, 8 insertions(+), 8 deletions(-)

commit f2ffa147c77effcd40ebce2647409caff6a4e065
Merge: ec22e6d 4bdf178
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 19 17:23:49 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit ec22e6de54be80104f67af3b4f51543fc44004e2
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 19 17:07:24 2025 +0200

    Creation of the separate file called "TimerAndScore" which creates the specific amount of time during which the player has to finish the maze. This particular files also handles increasing the score of the collected fruits, counting the collected fakefruits, finishing the game in case the player didnt suceed in finishing the game, and calculating the final of the player which is the combination of the score from the collected fruits and the remaining amount of time.

 Difficulty2.java   |  2 +-
 GameActions.java   | 47 +++++++++++++++++--------------
 MazeGameGUI.java   | 49 +++++++++++++++++++++++++++++---
 Player.java        | 18 ++++++------
 TimerAndScore.java | 82 ++++++++++++++++++++++++++++++++++++++++++++++++++++++
 5 files changed, 163 insertions(+), 35 deletions(-)
 create mode 100644 TimerAndScore.java

commit 4bdf178d17f4a6d0f54c4261bb5ee9476c112007
Merge: c60293e a070486
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 19 15:00:20 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit c60293e583f4fc9235959c2a900553fdb6eb5c6e
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 19 15:00:16 2025 +0200

    sound effects add.txl

 GameActions.java     |  17 ++++++++++++++++-
 sounds/fakefruit.wav | Bin 0 -> 165966 bytes
 sounds/fruit.wav     | Bin 0 -> 87630 bytes
 3 files changed, 16 insertions(+), 1 deletion(-)
 create mode 100644 sounds/fakefruit.wav
 create mode 100644 sounds/fruit.wav

commit a07048621726a7b8217085eefc034c6ef4af44d0
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 19 13:02:05 2025 +0200

    The reversal of the keyboard buttons now work as expected - after eating a fakefruit the directions of the keys are reversed, as well as the gui buttons positions are swapped in the maze gui panel for 10 secs. Furthermore, all windows close as expected after reaching the exit or running into a trap.

 .vscode/launch.json | 21 ++++++++++++++++
 Board.java          | 30 +++--------------------
 Difficulty2.java    |  4 ++--
 GameActions.java    | 69 ++++++++++++++++++++++++++++++++++++++++++++++-------
 MazeGameGUI.java    | 59 +++++++++++++++++++++++++++++++++++----------
 Player.java         |  9 ++++---
 6 files changed, 140 insertions(+), 52 deletions(-)
 create mode 100644 .vscode/launch.json

commit 18a25f21c950b0e5528ab14983f7767fa38f8627
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Fri Oct 17 21:20:42 2025 +0200

    Character interaction fixed.txl

 GameActions.java | 3 +++
 Player.java      | 2 ++
 2 files changed, 5 insertions(+)

commit c53b7740fce6d7fb13ae6358453fbbaa6d1ef75d
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Fri Oct 17 00:48:00 2025 +0200

    entities generation fixed.txl

 Board.java | 12 +++++++-----
 1 file changed, 7 insertions(+), 5 deletions(-)

commit eb4a434e564b1bd1c8236589b19f165574955f45
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 16 18:18:34 2025 +0200

    movement all fixed.txl

 MazeGameGUI.java | 8 ++++----
 1 file changed, 4 insertions(+), 4 deletions(-)

commit 329915266de89b0d07085843b92cc7ec009fc829
Merge: 549cf2f 75626b6
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 16 18:16:13 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 549cf2f85d2376268e5f31c34c59d4076ba0da97
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 16 17:48:17 2025 +0200

    movement almost fix.txl

 Board.java           | 294 ++++++++++++++++++++++++++++++++-------------------
 ControlReversal.java |   2 +-
 Difficulty.java      |   2 +-
 Difficulty2.java     |  79 ++++++++++++++
 FakeFruit.java       |   4 +-
 GameActions.java     |  86 +++++++++++++++
 GameMenu.java        |  26 ++++-
 GameObject.java      |  18 ++--
 GamePanel.java       |   8 --
 Main.java            |  15 ---
 MazeGameGUI.java     | 124 +++++++++++-----------
 Move.java            |  32 +++---
 Player.java          |  83 ++++++++++++---
 StartGame.java       |   7 ++
 game.java            |  39 -------
 15 files changed, 539 insertions(+), 280 deletions(-)
 create mode 100644 Difficulty2.java
 create mode 100644 GameActions.java
 delete mode 100644 GamePanel.java
 delete mode 100644 Main.java
 create mode 100644 StartGame.java
 delete mode 100644 game.java

commit 75626b6b440428af73ad4dab2aa698cba30760f6
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Thu Oct 16 13:24:20 2025 +0200

    slight improvements to the movement

 MazeGameGUI.java | 36 ++++++++++++++++++++++++------------
 Move.java        |  2 +-
 Player.java      | 56 +++++++++++++++++++++++++++++++++++++++++++++-----------
 3 files changed, 70 insertions(+), 24 deletions(-)

commit f216fa57971d42ddecc505e4949f023fbc63057e
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Thu Oct 16 11:51:18 2025 +0200

    1

 GameMenu.java |  1 +
 Move.java     | 15 +++------------
 Player.java   | 23 ++++++++++++-----------
 3 files changed, 16 insertions(+), 23 deletions(-)

commit e7c6d388e54e53378194b7f992a72dbe84bdd7ce
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Thu Oct 16 10:59:24 2025 +0200

    showing maze

 Board.java       | 257 ++++++++++++++++++++++++++++++++++++-------------------
 Difficulty2.java |  15 ++--
 GameObject.java  |  18 ++--
 MazeGameGUI.java |   9 +-
 Move.java        |   6 +-
 5 files changed, 189 insertions(+), 116 deletions(-)

commit f0c5bb029b52c5b289ac543294e3fd5593af83bd
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Wed Oct 15 21:41:03 2025 +0200

    1

 Board.java           | 101 ++++++++++++++++++++++++++-------------------------
 ControlReversal.java |   2 +-
 Difficulty.java      |   2 +-
 Difficulty2.java     |  76 ++++++++++++++++++++++++++++++++++++++
 FakeFruit.java       |   4 +-
 GameActions.java     |  86 +++++++++++++++++++++++++++++++++++++++++++
 GameMenu.java        |  25 +++++++++++--
 GamePanel.java       |   8 ----
 Main.java            |  15 --------
 MazeGameGUI.java     | 101 ++++++++++++++++++++++++---------------------------
 Move.java            |  15 ++++++--
 Player.java          |  34 +++++++++++++----
 StartGame.java       |   7 ++++
 game.java            |  39 --------------------
 14 files changed, 329 insertions(+), 186 deletions(-)
 create mode 100644 Difficulty2.java
 create mode 100644 GameActions.java
 delete mode 100644 GamePanel.java
 delete mode 100644 Main.java
 create mode 100644 StartGame.java
 delete mode 100644 game.java

commit da08953b6f3f696a6b238164e332bba1924f4024
Merge: 96a5258 bed0a29
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:11:58 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 96a5258546600161e09555eae6a57df86b727756
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:11:51 2025 +0200

    Difficulty.txl

 CBL-Maze-Game | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)

commit bed0a29d842ceaac054341f638db3908b94f3c89
Merge: 2ddba12 5bd3ee0
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:11:16 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 5bd3ee01c726d0306f78da1d9316020e9e3dbcb4
Merge: c685a3b 8533b43
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:11:01 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit c685a3b13824d7dfef07a8b543a432afcb26a931
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:10:40 2025 +0200

    difficulty

 CBL-Maze-Game | 2 +-
 1 file changed, 1 insertion(+), 1 deletion(-)

commit 2ddba12eb661df96f8e9a23ac89f9d74763178c1
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 16:10:32 2025 +0200

    FakeFruits

 ControlReversal.java | 26 ++++++++++++++++++++++++++
 FakeFruit.java       |  4 ++++
 2 files changed, 30 insertions(+)
 create mode 100644 ControlReversal.java

commit bf2e1b36e21fd7dbd139b9108e8e9cd790ec354a
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Tue Oct 14 15:28:16 2025 +0200

    Difficulty,FakeFruitsAdded

 CBL-Maze-Game   |  2 +-
 Difficulty.java | 42 ++++++++++++++++++++++++++++++++++++++++++
 GameMenu.java   | 14 ++++++++++++++
 3 files changed, 57 insertions(+), 1 deletion(-)
 create mode 100644 Difficulty.java

commit 8533b436dd26f8ec353af91d3f37d2bcf8e98111
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Mon Oct 13 21:02:54 2025 +0200

    MazeGameGui almost finished

 Functions/FakeFruit.java |   2 +-
 Functions/Fruit.java     |   2 +-
 Functions/Trap.java      |   2 +-
 GenerateBoard.java       |   3 --
 MazeGameGUI.java         | 135 ++++++++++++++++++++++++++++++++++++++++++++++-
 Player.java              |   1 +
 6 files changed, 138 insertions(+), 7 deletions(-)
 delete mode 100644 GenerateBoard.java

commit f188eec28835550dc8e3d64419ce08497e228f51
Merge: 9985581 575b7fc
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Mon Oct 13 15:10:50 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit 99855817eb2dd7f6ae68e65ffb23729e4142d34b
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Mon Oct 13 15:10:45 2025 +0200

    new changes

 Board.java       | 11 ++++++++++-
 GameObject.java  |  2 +-
 MazeGameGUI.java | 10 ++++++++++
 Move.java        | 44 ++++++++++++++++++++++++++++++++++++++++++++
 MoveDown.java    |  6 ++++++
 MoveLeft.java    |  6 ++++++
 MoveRight.java   |  7 +++++++
 MoveUp.java      |  7 +++++++
 Player.java      | 41 +++++++++++++++++++++++++++++++++++++++++
 9 files changed, 132 insertions(+), 2 deletions(-)
 create mode 100644 MazeGameGUI.java
 create mode 100644 Move.java
 create mode 100644 MoveDown.java
 create mode 100644 MoveLeft.java
 create mode 100644 MoveRight.java
 create mode 100644 MoveUp.java
 create mode 100644 Player.java

commit 575b7fce3e9bc696dabbcc7c8676e10ec0edc501
Merge: fafa088 6209559
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 12 20:31:15 2025 +0200

    Merge branch 'main' of https://github.com/12Brayden12/CBL-Maze-Game

commit fafa08818c0bc4cb05d7f6f52f81013837b9cc53
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 12 20:31:00 2025 +0200

    SoundManager added

 Functions/Entity.java       | 24 ++++++++++++++++++++++++
 Functions/Exit.java         | 14 ++++++++++++++
 Functions/FakeFruit.java    | 16 ++++++++++++++++
 Functions/Fruit.java        | 16 ++++++++++++++++
 Functions/TimerManager.java | 30 ++++++++++++++++++++++++++++++
 Functions/Trap.java         | 14 ++++++++++++++
 GamePanel.java              | 13 ++++++-------
 SoundManager.java           | 21 +++++++++++++++++++++
 game.java                   | 39 +++++++++++++++++++++++++++++++++++++++
 9 files changed, 180 insertions(+), 7 deletions(-)
 create mode 100644 Functions/Entity.java
 create mode 100644 Functions/Exit.java
 create mode 100644 Functions/FakeFruit.java
 create mode 100644 Functions/Fruit.java
 create mode 100644 Functions/TimerManager.java
 create mode 100644 Functions/Trap.java
 create mode 100644 SoundManager.java
 create mode 100644 game.java

commit 6209559ed2f409792dae9a2671d61e4debc0a006
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Sun Oct 12 18:59:35 2025 +0200

    first attempt.txl

 Board.java      | 192 ++++++++++++++++++++++++++++++++++++++++++++++----------
 FakeFruit.java  |   6 ++
 Fruit.java      |   8 +++
 GameObject.java |  41 ++++++++++++
 Position.java   |  17 ++---
 Trap.java       |   7 +++
 6 files changed, 230 insertions(+), 41 deletions(-)
 create mode 100644 FakeFruit.java
 create mode 100644 Fruit.java
 create mode 100644 GameObject.java
 create mode 100644 Trap.java

commit d033d14bedf039a1c3a62b867d2cff24716a6999
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Sun Oct 12 18:59:02 2025 +0200

    second submission.txl

 CBL-Maze-Game  | 1 +
 GamePanel.java | 9 +++++++++
 Main.java      | 9 ++++++++-
 3 files changed, 18 insertions(+), 1 deletion(-)
 create mode 160000 CBL-Maze-Game
 create mode 100644 GamePanel.java

commit 1a29d37b2a5a985847bb445ff723d243332ae781
Author: SoulForSeek <savoury.aderral91@posteo.com>
Date:   Fri Oct 10 20:58:28 2025 +0200

    smth

 Board.java         | 156 +++++++++++++++++++++++++++++++++++++++++++++++++++++
 GameMenu.java      | 114 +++++++++++++++++++++++++++++++++++++++
 GenerateBoard.java |   3 ++
 Position.java      |  26 +++++++++
 4 files changed, 299 insertions(+)
 create mode 100644 Board.java
 create mode 100644 GameMenu.java
 create mode 100644 GenerateBoard.java
 create mode 100644 Position.java

commit 3467327461ca640ebd77d5bafab4ff4c2de3acd6
Author: 12Brayden12 <z.deng2@student.tue.nl>
Date:   Thu Oct 9 18:57:43 2025 +0200

    first submission

 Main.java | 8 ++++++++
 1 file changed, 8 insertions(+)
 create mode 100644 Main.java
