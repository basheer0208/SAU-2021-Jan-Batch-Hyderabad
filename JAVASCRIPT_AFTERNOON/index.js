var ar = [1, 2, 3, 4, 5];
function map(ar,a,b)
{
    let sum=0;
    for(var i=0;i<ar.length;i++)
    {
        sum=b(sum,ar[i])
    }
     return sum;
}  
var final = map(ar,0,(x,y)=> x+y);
console.log(final)
document.getElementById('ans').innerHTML = final;