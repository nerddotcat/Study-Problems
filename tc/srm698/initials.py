
class Initials:

	def getInitials(self,name):
		words = name.split()
		out = []
		for word in words:
			out.append(word[0])
	
		return "".join(out)
