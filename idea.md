# Ideas;

- Zombie apocolypse
    - Zombie vs human
    - Zombies will win
    - Pathfinding algorithm
    - Features
        - See the zombies until their in x radius
        - Safe zones
        - Day and night time different effects are applied to classes
    - Background;
        - Ruined background
        - Blocked pathway
    - Tools
        - Cure


        - Day vs night
            - Day;
                - Zombies are slowed
                - Humans are still able to move around
            - [DONE — implemented as a Strategy pattern
              (ZombieStrategy / ChaseStrategy / NightChaseStrategy / DayChaseStrategy)]

        - Balance tuning [SEPARATE from the day/night slowdown above]
            - Zombies were winning almost every simulation run even with the day/night
              slowdown in place
            - Diagnosed the real cause: zombies always use active A* pathfinding to hunt,
              while humans mostly wander randomly until they happen to notice a cure —
              a structural asymmetry, not a numbers problem
            - Tuned: randomised cure spawn interval (was fixed), widened curing radius
              (1 -> 2 tiles), raised cure cap (6 -> 10), widened human cure-detection radius
            - Zombies still tend to win most games — noted as an open issue, since a full
              fix would mean giving Human's wander behaviour some awareness too, not just
              adjusting numbers


- Draw on JPanel inside of JFrame
- Simulation must be watchable
- Pause play and fast foward button [Pause done. Fast forward/speed control still open]
- Day and night environment + logo shown
- Time so you know the time
- Count on zombies, humans and cures that are on the screen
- Bottom of the screen will have a current effect status showing [Partially done —
  a live scrolling event log was added instead of a single status line]
- All characters will be locked to the middle of their screen
- Use an array matrix to define what is shelter, land, sea.
- No one is able to go on the sea
- Shelter is just for humans and they are imune from the zombies
- Make the map backend a 2d array and then the generated aspects are created based off that
- Make the number of columns easily adjustable
    - Backend algoirthm to make sure the 2d array matches the number of column
- Simulation should run by default and speeds should be adjustable by a button that goes form 0.5, 1, 2, and 4 times speed