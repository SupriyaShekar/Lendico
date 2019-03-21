# Lendico
This is a project to calculate monthly interest for loan amount
I designed and implemented the task in Java 8 as a Maven project. 
Download the project open in eclipse and run the project.
Please provide inputs : Loan Amount, Simple Interest, Duration, Date.
Output will be generated in Lendico.json format.
Example : 
Inputs - 
Loan Amount = 5000
Interest = 0.05
Duration = 24(in months)
Date = 01-01-2018(dd-mm-yyyy)
Outputs -
Generated Json File :
{
"borrowerPaymentAmount:" : "218.74998"
"Date" : "2018-01-01T00:00:00.000Z"
"initialOutstandingPrincipal" : "5000.0"
"interest" : "20.833334"
"principal" : "197.91666"
"remainingOutstandingPrincipal" : "4802.0835"
},
{
"borrowerPaymentAmount:" : "218.74998"
"Date" : "2018-02-01T00:00:00.000Z"
"initialOutstandingPrincipal" : "4802.0835"
"interest" : "20.00868"
"principal" : "198.7413"
"remainingOutstandingPrincipal" : "4603.3423"
},
...................
