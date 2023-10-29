export interface Product {
    id: number; 
    name: string;
    internalName: string;
    details: string;
    maxProductsPerLocation: number;
}

export interface Feature{
    id: number;
    name: string;
    internalName: string;
    details: string;
    productName: string;
    productInternalName: string;
}

export interface Parameter{
    id: number;
    name: string;
    internalName: string;
    details: string;
    parameterType: ParameterType;
    value: string
}
 
export enum ParameterType {
    QUANTITY = 'QUANTITY',
    PRICE = 'PRICE',
    OTHER = 'OTHER',
}
  