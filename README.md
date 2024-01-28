# puzzleSolver

This project was made after my friend showed me a homemade puzzle he made. It took me a while to solve it by hand so I thought of making a program that solves it for me. The goal is to align the pieces on the puzzle so that only two squares that are exposed correspond to the current date. I have included images of the puzzle in the repository.

My first approach:
Each piece has either 2, 4 or 8 different permutations depending on their symmetry. There are 8 pieces total so if you include all the permutations and place them on the board you can find the desired solution. This is the approach that is currently in the repo.

My future approach:
I found my first solution unsatisfactory in terms of efficiency so I did some research on the internet and found out that I can actually use the exact cover algorithm to solve this puzzle. I will be including that soon and it will be way more efficient. 
