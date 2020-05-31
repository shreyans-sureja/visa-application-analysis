# visa-application-analysis

## Problem Statement - 

There is a list of people who are willing to take a Visa for visiting the Country MauritIus, read a text file having entries like 

### Input Format in text file: 
- Jyoti,  10, Abcd corner, SFO, USA, test1@gmail.com  \
- Tesla, 55, House no 78, Nirala Nagar, Lucknow, U.P., India, test144@gmail  \
- Nishant, 12, , test11@gm.com  \
- Helen, 5, South Point, Lane 189, Kerala, India, test15@gail.com  \
- Toshi, 55, Uday Apartments, Noida, U.P., India, test14@gmail.com  \
- Zeeshan,  , abfh, Iran, test01gmail.com  

#### Categorize the people are per their age and tag them as a Kid or Adult.  
- If Age > 18 then Adult\
- If Age <18 then Kid 

Copy the names and category in a new CSV (comma separated values) file which can be opened via Excel tool.   
 
### Constraints to be used while copying data to CSV file:  

- Any of the value in fields : age or address can be empty.
- Eliminate people who do not have the correct email ids.
- Eliminate people who are not living in India.
- Eliminate people who do not have any address given  
- The input order of the list of people should be maintained in the output file  
- All entries and header should be present in the CSV file 

### Output:  
- Helen, Kid\
- Toshi, Adult
