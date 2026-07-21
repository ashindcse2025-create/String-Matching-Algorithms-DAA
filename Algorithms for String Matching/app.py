from flask import Flask, render_template, request

app = Flask(__name__)


# Naive Algorithm
def naive(text, pattern):

    positions=[]

    for i in range(len(text)-len(pattern)+1):

        if text[i:i+len(pattern)] == pattern:
            positions.append(i)

    return positions



# Rabin Karp Algorithm
def rabin_karp(text, pattern):

    positions=[]

    m=len(pattern)
    n=len(text)

    pattern_hash=hash(pattern)

    for i in range(n-m+1):

        if hash(text[i:i+m]) == pattern_hash:

            if text[i:i+m]==pattern:
                positions.append(i)

    return positions



# KMP Algorithm
def kmp(text, pattern):

    positions=[]

    lps=[0]*len(pattern)

    length=0
    i=1


    while i<len(pattern):

        if pattern[i]==pattern[length]:

            length+=1
            lps[i]=length
            i+=1

        elif length:

            length=lps[length-1]

        else:

            lps[i]=0
            i+=1



    i=j=0

    while i<len(text):

        if text[i]==pattern[j]:

            i+=1
            j+=1


        if j==len(pattern):

            positions.append(i-j)
            j=lps[j-1]


        elif i<len(text) and text[i]!=pattern[j]:

            if j:
                j=lps[j-1]

            else:
                i+=1


    return positions



@app.route("/",methods=["GET","POST"])
def home():

    result={}

    if request.method=="POST":

        text=request.form["text"]
        pattern=request.form["pattern"]

        result["Naive"]=naive(text,pattern)

        result["Rabin-Karp"]=rabin_karp(text,pattern)

        result["KMP"]=kmp(text,pattern)


    return render_template("index.html",result=result)



if __name__=="__main__":
    app.run(debug=True)