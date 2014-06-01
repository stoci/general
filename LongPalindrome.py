def longPal(sentence):
	#split sentence and declare return string
	words = sentence.split()
	longest=""
	# check all words in sentence
	for x in words:
		#check reverse string and length
		if(x[::-1]==x and len(x)>len(longest)):
			longest=x;
	return longest

# call function defined above, print return value
print(longPal("jump into the sea paap joooooooj mom"))