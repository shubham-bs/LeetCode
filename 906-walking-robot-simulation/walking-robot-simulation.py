class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dirc = [(0,1) ,(1, 0) ,(0 ,-1) ,(-1 ,0)]
        d = 0

        x, y = 0 ,0
        maxDisc = 0

        obs = set(map(tuple, obstacles))

        for cmd in commands:
            if cmd == -1:
                d = (d +1) % 4
            if cmd == -2:
                d = (d -1) % 4
            else:
                dx ,dy = dirc[d]
                for i in range(cmd):
                    if (x +dx , y +dy) not in obs:
                        x += dx
                        y += dy

                maxDisc = max(maxDisc, x ** 2 + y ** 2)

        return maxDisc


        