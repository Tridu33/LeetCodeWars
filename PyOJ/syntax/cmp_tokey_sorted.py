def main():
    from functools import cmp_to_key
    students = [
       {"name": "Alice", "score": 85},
       {"name": "Bob", "score": 75},
       {"name": "Charlie", "score": 85}
    ]
    def compare(s1, s2):
       if s1["score"] != s2["score"]:
           return s1["score"] - s2["score"] # 成绩从小到大
       if s1["name"] < s2["name"]:
           return -1
       elif s1["name"] > s2["name"]:
           return 1
       else:
           return 0
    sorted_students = sorted(students, key=cmp_to_key(compare))
    print(sorted_students)

def test():
    from functools import total_ordering

    @total_ordering
    class Point:
        def __init__(self, x, y):
            self.x = x
            self.y = y

        def __lt__(self, other):
            return (self.x, self.y) < (other.x, other.y)

        def __eq__(self, other):
            return (self.x, self.y) == (other.x, other.y)

    # 创建两个 Point 对象
    point1 = Point(1, 2)
    point2 = Point(2, 1)

    # 使用其他比较运算符进行比较
    print(point1 <= point2)  # 输出: True
    print(point1 >= point2)  # 输出: False

if __name__ == '__main__':
    main()