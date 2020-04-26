from PIL import Image, ImageChops
from string import lowercase
import glob
def getletter(img_block):
    for l in alphabet:
        found = True
        cutoff = 20 if l not in lowercase else 250
        for i in range(len(img_block)):
            ri1,gi1,bi1 = img_block[i]
            ri2,gi2,bi2 = alphabet[l][i]
            if abs(ri1 - ri2) > cutoff:
                found = False
                break
            if abs(gi1 - gi2) > cutoff:
                found = False
                break
            if abs(bi1 - bi2) > cutoff:
                found = False
                break
        if found:
            if 'spa' in l:
                return " "
            if 'komma' in l:
                return ","
            return l
    # exit()
    # img_block.show()
    # raw_input()

    return "?"

def array_maker(img):
    array = []
    for i in range(3):
        for j in range(2):
            array.append(img.getpixel((j, i)))
    return array

def extract_letters():
    ans = []
    bw, bh = 2,3
    imgwidth, imgheight = img.size
    for i in range(PADDING[1],imgheight-PADDING[1],bh):
        for j in range(PADDING[0],imgwidth-PADDING[0],bw):
            box = (j, i, j+bw, i+bh)
            a = img.crop(box)
            a_arr = array_maker(a.convert('RGB'))
            l = getletter(a_arr)

            ans.append(l)
            # print ans
            # a.convert('1').show()
            # alphabet[ans[0]].convert('1').show()
            # raw_input()
    print "".join(ans)




PADDING = [2,2] #width, heigt
img = Image.open("./output.png")
alphabet = {}
for filename in glob.glob('./alphabet/*.png'): #assuming gif
    im=Image.open(filename)
    im = im.resize((2,3))
    # im.show()
    # raw_input()
    letter = filename.split('.')[1].split('/')[-1]
    alphabet[letter] = array_maker(im.convert('RGB'))

extract_letters()
