def calculate(n1, op, n2):
    match op:
        case "+":
            return n1 + n2
        case "-":
            return n1 - n2
        case "*":
            return n1 * n2 + 0.0
        case "/":
            n1 / n2 if n2 != 0 else None
        case default:
            return None
