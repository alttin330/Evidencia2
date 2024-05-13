const { ApolloServer } = require('apollo-server')
const mongoose = require('mongoose')

const MONGODB = "mongodb+srv://hostingmiopags:mwQrnOurNcLtxyzo@test.qhydteh.mongodb.net/?retryWrites=true&w=majority&appName=test"

// Apollo Server

// typeDefs: GraphOL. Type Definitions
// rosalvera: How do no resolve queries / mutations

const typeDefs = require('./graphql/typeDefs')
const resolvers = require('./graphql/resolvers')

const server = new ApolloServer({
   typeDefs,
    resolvers
})

mongoose.connect(MONGODB, { useNewurlParser: true})
    .then(() => {
        console.log("MongoD& Connection successful");
        return server.listen({ port: 5000});    
    }) 
    .then((res) => {
        console.log(`Server running at ${res.url}`)    
    })