# GameEngineTest
## Overview
This is my work-in-progress ECS Java game engine, built on LWJGL and OpenGL. It is based on having a single window which can be occupied by various scenes, each containing its own entities, game objects, etc., with an emphasis on customizability. Game objects can be built completely from scratch for complete control or created and modifed quickly using pre-built classes and methods. Custom shaders written in GLSL can be created too. This project is a work in progress, and is likely going to change dramatically as I find less-confusing ways to organize game objects and their classes. Or it might be completely rewritten, we'll see. The low level stuff such as the current implementation of the ECS is based on the first 10ish videos of [this playlist](https://www.youtube.com/watch?v=VyKE7vz65rY&list=PLtrSb4XxIVbp8AKuEAlwNXDxr99e3woGE&ab_channel=GamesWithGabe).
## Things to Add
- Sounds/ Music
- More classes for premade game objects and components (ie buttons for menus, dedicated background game objects, etc.)
- Bounding boxes for easier collision detection
- Priority system for rendering, so sprites can be consistently in front or behind each other without worrying about when they were drawn
- Javadocs
## Things to Change
- The renderer needs to be optimized some
- Needs a more well defined hierarchy for game objects
- Better way to control moving sprites
- Better way to create vertex array
- Better organized code
- Should probably be rewritten in C++
