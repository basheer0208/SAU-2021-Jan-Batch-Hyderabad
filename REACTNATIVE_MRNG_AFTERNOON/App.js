  
import { StatusBar } from 'expo-status-bar';
import axios from 'axios';
import React, {useState} from 'react';
import { StyleSheet, Text, View ,TextInput ,ScrollView ,Image ,TouchableHighlight,Modal} from 'react-native';

export default function App() {
  const apiurl="https://api.themoviedb.org/3/movie/popular";
  const [state,setState]=useState({
    s: "Enter a movie....",
    results: [],
    selected: {}
  });
  const search = () =>{
    axios(apiurl +"&s="+state.s).then(({data})=> {
      let results=data.searchconsole.log(results)
      setState(prevState => {
        return { ...prevState,results: results }
      })
    })
  }
  const openPopup =id =>
  {
    axios(apiurl +"&i="+id).then(({ data }) => {
      let result=data;
      console.log(result);
      setState(prevState => {
        return { ...prevState ,selected: result }
      });
    });
  }
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Movie App</Text>
      <TextInput
      style={styles.searchbox}
      onChangeText={text => setState(prevState =>{
        return {...prevState,s:text}
      })}
      onSubmitEditing={search}
      value={state.s}
      />
      <ScrollView style={styles.results}>
           {state.results.map(RESULT =>
           <TouchableHeighlight onPress={() => openPopup(result.imdbID)}>
           <View key={result.imdbID} style={styles.result}>
             <Image
             source={{uri:result.Poster}}
             style={{
               width:'100%',
               heigth:300
             }}
             resizeMode="cover"
             />
             <Text style={styles.heading}>{result.Title}</Text>
           </View>
           </TouchableHeighlight>
           )}
      </ScrollView>
      <Modal>
         animationType="fade"
         transparent={false}
         visible={(typeof state.selected.Title !="undefined")}
         
         <view style={styles.popup}>
           <Text style={styles.poptitle}>{state.selected.Title}</Text>
           <Text style={{marginBottom :20}}>Rating: {state.selected.tmdbRating}</Text>
           <Text>{state.selected.Plot}</Text>

         </view>
         <TouchableHeighlight
         onPress={ ()=> setState(prevState => {
           return { ...prevState, selected: {} }
         })}
         >
           <Text style={styles.closeBtn}>Close</Text>
         </TouchableHeighlight>

      
      <StatusBar style="auto" />
      </Modal>
    </View>
  ); 
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 70,
    paddingHorizontal:20
  },
  title:{
    color: '#fff',
    fontSize: 32,
    fontWeight: '700',
    alignItems: 'center',
    marginBottom: 20

  },
  searchbox:{
    backgroundcolor: '#fff',
    fontSize: 32,
    fontWeight: '700',
    padding:20,
    width: '100%',
   
    marginRadius: 8,
    marginBottom: 40
  },
  results:
  {
    flex: 1,
  },
  result:
  {
    flex:1,
    width:'100%',
    marginBottom:20
  },
  heading: {
    color:'#FFF',
    fontsize:18,
    fontWeight:'700',
    padding:20,
    bacgroundColor:'#445565'
  },
  popup:{
    padding:20
  },
  poptitle:{
    fontSize:24,
    fontWeight:'700',
    marginBottom:5
  },
  closeBtn:{
    padding:20,
    fontSize:20,
    fontWeight:'700',
    color:'#FFF',
    backgroundColor:'#248404'
  }
});
}
