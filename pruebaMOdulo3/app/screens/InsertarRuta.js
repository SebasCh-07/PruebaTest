import { StyleSheet, Text, View, FlatList, TextInput, Button, Alert, ScrollView, Modal, TouchableOpacity} from 'react-native';
import { useState } from 'react';
import { servicioCrearRuta } from './services/TestServices'
export const insertarRutas = ({ navigation }) => {
    const [codigo, setCodigo] = useState('');
    const [origen, setOrigen] = useState('');
    const [destino, setDestino] = useState('');
    const [bus, setBus] = useState('');

    const createService = () => {
        servicioCrearRuta( {
            codigoR: codigo,
            origen: origen,
            destino: destino,
            bus: {
                idBUS: bus,
            }
        },
        () => {
            Alert.alert("CONFIRMACIÓN","SE HA INGRESADO EL NUEVO POST")
        });
    }
    return <View StyleSheet={styles.container}>
        <View style={styles.container}></View>

        <TextInput
            placeholder='Codigo'
            style={styles.Input}
            value={codigo}
            onChangeText={(value)=> 
                {setCodigo(value)}}
        />
        <TextInput
            placeholder='Origen'
            style={styles.Input}
            value={origen}
            onChangeText={(value)=> 
                {setOrigen(value)}}
        />
        <TextInput
            placeholder='Destino'
            style={styles.Input}
            value={destino}
            onChangeText={(value)=> 
                {setDestino(value)}}
        />
        <TextInput
            placeholder='Bus'
            style={styles.Input}
            value={bus}
            onChangeText={(value)=> 
                {setBus(value)}}
        />
        <Button 
        title='Enviar'
        onPress={createService}
        />
    </View>

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    Input: {
        height: 40,
        margin: 12,
        borderWidth: 1,
        padding: 10,
        borderRadius: 20,
    }
});