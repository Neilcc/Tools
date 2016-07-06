__author__ = 'cc'

if __name__ == '__main__':

    while True:
        red = input("input red:")
        red = hex(red).split("x")[1]
        if red.__len__() == 1:
            red = "0" + red
        green = input("input green")
        green = hex(green).split("x")[1]
        if green.__len__() == 1:
            green = "0" + green
        blue = input("input blue")
        blue = hex(blue).split("x")[1]
        if blue.__len__() == 1:
            blue = "0" + blue
        str = "#" + red + green + blue
        print(str)
