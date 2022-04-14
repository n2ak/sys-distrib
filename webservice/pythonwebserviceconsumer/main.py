from zeep import Client


client = Client("http://localhost/8484/BanqueService?wsdl")
def printCompte(c):
    print("----------")
    print("id: ",c.id)
    print("date: ",c.date)

print(client.service.convertFromEu2Dh(53))

printCompte(client.service.getCompte(4))

list(map(printCompte,client.service.getComptes()))