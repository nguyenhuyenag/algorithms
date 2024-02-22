import unittest


class Solution(unittest.TestCase):

    def simplifyPath_OK(self, paths: str) -> str:
        stack = []
        for path in paths.split("/"):
            if len(path) == 0 or path == ".":
                continue
            elif path == "..":
                if len(stack) > 0:
                    stack.pop()
            else:
                stack.append(path)

        return "/" + "/".join(stack)

    def simplifyPath(self, paths: str) -> str:
        stack = []
        for path in paths.split("/"):
            if path and path == "..":
                if len(stack) > 0:
                    stack.pop()
            elif path not in ["", ".", ".."]:
                stack.append(path)

        return "/" + "/".join(stack)

    def test(self):
        self.assertEqual("/home", self.simplifyPath("/home/"))
        self.assertEqual("/", self.simplifyPath("/../"))
        self.assertEqual("/home/foo", self.simplifyPath("/home//foo/"))
        self.assertEqual("/c", self.simplifyPath("/a/./b/../../c/"))


if __name__ == '__main__':
    unittest.main()
