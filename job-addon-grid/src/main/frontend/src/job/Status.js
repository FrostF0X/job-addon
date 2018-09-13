export default class Status {
    static Success = 'success';
    static Fail = 'fail';
    static Running = 'running';

    static enumerators = [Status.Success, Status.Fail, Status.Running];

    static fromPlain(value) {
        if(Status.enumerators.includes(value)){
            return value;
        }
        throw new Error("Available status values are: " + Status.enumerators);
    }
}
