#recursive factorial solution
def factorial(n):
	f = 1
	
	#base case
	if(n==0 or n==1):
		return f
	#recursion
	else:
		f = n*factorial(n-1)
	return f

#input function waits for user input
n = input("Enter a whole number to receive factorial.")
print(factorial(int(n)))
